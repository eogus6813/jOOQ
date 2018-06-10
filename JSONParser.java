package org.jooq.tools.json;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


/**
 * Parser for JSON text. Please note that JSONParser is NOT thread-safe.
 *
 * @author FangYidong<fangyidong@yahoo.com.cn>
 */
@SuppressWarnings({ "hiding", "javadoc", "rawtypes", "unchecked" })
public class JSONParser {
    public static final int S_INIT=0;
    public static final int S_IN_FINISHED_VALUE=1;//string,number,boolean,null,object,array
    public static final int S_IN_OBJECT=2;
    public static final int S_IN_ARRAY=3;
    public static final int S_PASSED_PAIR_KEY=4;
    public static final int S_IN_PAIR_VALUE=5;
    public static final int S_END=6;
    public static final int S_IN_ERROR=-1;

    private Factory_json factory = new Factory_json();
    private LinkedList handlerStatusStack;
    private int status = S_INIT;

    private int peekStatus(LinkedList statusStack){
        if(statusStack.size()==0)
            return -1;
        Integer status=(Integer)statusStack.getFirst();
        return status.intValue();
    }
    
    factory.create();

    /**
     *  Reset the parser to the initial state without resetting the underlying reader.
     *
     */
    public void reset(){
        token = null;
        status = S_INIT;
        handlerStatusStack = null;
    }

    /**
     * Reset the parser to the initial state with a new character reader.
     *
     * @param in - The new character reader.
     * @throws IOException
     * @throws ParseException
     */
    public void reset(Reader in){
        lexer.yyreset(in);
        reset();
    }

    /**
     * @return The position of the beginning of the current token.
     */
    public int getPosition(){
        return lexer.getPosition();
    }
    
    public int getStatus() {
    	return status;
    }
    
    public Yytoken getToken() {
    	return token;
    }

    public Object parse(String s) throws ParseException{
        return parse(s, (ContainerFactory)null);
    }

    public Object parse(String s, ContainerFactory containerFactory) throws ParseException{
        StringReader in=new StringReader(s);
        try{
            return parse(in, containerFactory);
        }
        catch(IOException ie){
                        /*
                         * Actually it will never happen.
                         */
            throw new ParseException(-1, ParseException.ERROR_UNEXPECTED_EXCEPTION, ie);
        }
    }

    public Object parse(Reader in) throws IOException, ParseException{
        return parse(in, (ContainerFactory)null);
    }

    /**
     * Parse JSON text into java object from the input source.
     *
     * @param in
     * @param containerFactory - Use this factory to createyour own JSON object and JSON array containers.
     * @return Instance of the following:
     *  org.json.simple.JSONObject,
     *      org.json.simple.JSONArray,
     *      java.lang.String,
     *      java.lang.Number,
     *      java.lang.Boolean,
     *      null
     *
     * @throws IOException
     * @throws ParseException
     */
    public Object parse(Reader in, ContainerFactory containerFactory) throws IOException, ParseException{
        reset(in);
        
        LinkedList statusStack = new LinkedList();
        LinkedList valueStack = new LinkedList();

        try{
            do{
                nextToken();
                switch(getStatus()){
                    case S_INIT:
                        switch(getToken().type){
                            case Yytoken.TYPE_VALUE:
                                status=S_IN_FINISHED_VALUE;
                                statusStack.addFirst(new Integer(getStatus()));
                                valueStack.addFirst(token.value);
                                break;
                            case Yytoken.TYPE_LEFT_BRACE:
                                status=S_IN_OBJECT;
                                statusStack.addFirst(new Integer(getStatus()));
                                valueStack.addFirst(createObjectContainer(containerFactory));
                                break;
                            case Yytoken.TYPE_LEFT_SQUARE:
                                status=S_IN_ARRAY;
                                statusStack.addFirst(new Integer(getStatus()));
                                valueStack.addFirst(createArrayContainer(containerFactory));
                                break;
                            default:
                                status=S_IN_ERROR;
                        }//inner switch
                        break;

                    case S_IN_FINISHED_VALUE:
                        if(getToken().type==Yytoken.TYPE_EOF)
                            return valueStack.removeFirst();
                        else
                            throw new ParseException(getPosition(), ParseException.ERROR_UNEXPECTED_TOKEN, getToken());

                    case S_IN_OBJECT:
                        switch(getToken().type){
                            case Yytoken.TYPE_COMMA:
                                break;
                            case Yytoken.TYPE_VALUE:
                                if(getToken().value instanceof String){
                                    String key=(String)getToken().value;
                                    valueStack.addFirst(key);
                                    status=S_PASSED_PAIR_KEY;
                                    statusStack.addFirst(new Integer(getStatus()));
                                }
                                else{
                                    status=S_IN_ERROR;
                                }
                                break;
                            case Yytoken.TYPE_RIGHT_BRACE:
                                if(valueStack.size()>1){
                                    statusStack.removeFirst();
                                    valueStack.removeFirst();
                                    status=peekStatus(statusStack);
                                }
                                else{
                                    status=S_IN_FINISHED_VALUE;
                                }
                                break;
                            default:
                                status=S_IN_ERROR;
                                break;
                        }//inner switch
                        break;

                    case S_PASSED_PAIR_KEY:
                        switch(getToken().type){
                            case Yytoken.TYPE_COLON:
                                break;
                            case Yytoken.TYPE_VALUE:
                                statusStack.removeFirst();
                                String key=(String)valueStack.removeFirst();
                                Map parent=(Map)valueStack.getFirst();
                                parent.put(key,getToken().value);
                                status=peekStatus(statusStack);
                                break;
                            case Yytoken.TYPE_LEFT_SQUARE:
                                statusStack.removeFirst();
                                key=(String)valueStack.removeFirst();
                                parent=(Map)valueStack.getFirst();
                                List newArray=createArrayContainer(containerFactory);
                                parent.put(key,newArray);
                                status=S_IN_ARRAY;
                                statusStack.addFirst(new Integer(getStatus()));
                                valueStack.addFirst(newArray);
                                break;
                            case Yytoken.TYPE_LEFT_BRACE:
                                statusStack.removeFirst();
                                key=(String)valueStack.removeFirst();
                                parent=(Map)valueStack.getFirst();
                                Map newObject=createObjectContainer(containerFactory);
                                parent.put(key,newObject);
                                status=S_IN_OBJECT;
                                statusStack.addFirst(new Integer(getStatus()));
                                valueStack.addFirst(newObject);
                                break;
                            default:
                                status=S_IN_ERROR;
                        }
                        break;

                    case S_IN_ARRAY:
                        switch(getToken().type){
                            case Yytoken.TYPE_COMMA:
                                break;
                            case Yytoken.TYPE_VALUE:
                                List val=(List)valueStack.getFirst();
                                val.add(getToken().value);
                                break;
                            case Yytoken.TYPE_RIGHT_SQUARE:
                                if(valueStack.size()>1){
                                    statusStack.removeFirst();
                                    valueStack.removeFirst();
                                    status=peekStatus(statusStack);
                                }
                                else{
                                    status=S_IN_FINISHED_VALUE;
                                }
                                break;
                            case Yytoken.TYPE_LEFT_BRACE:
                                val=(List)valueStack.getFirst();
                                Map newObject=createObjectContainer(containerFactory);
                                val.add(newObject);
                                status=S_IN_OBJECT;
                                statusStack.addFirst(new Integer(getStatus()));
                                valueStack.addFirst(newObject);
                                break;
                            case Yytoken.TYPE_LEFT_SQUARE:
                                val=(List)valueStack.getFirst();
                                List newArray=createArrayContainer(containerFactory);
                                val.add(newArray);
                                status=S_IN_ARRAY;
                                statusStack.addFirst(new Integer(getStatus()));
                                valueStack.addFirst(newArray);
                                break;
                            default:
                                status=S_IN_ERROR;
                        }//inner switch
                        break;
                    case S_IN_ERROR:
                        throw new ParseException(getPosition(), ParseException.ERROR_UNEXPECTED_TOKEN, getToken());
                }//switch
                if(getStatus()==S_IN_ERROR){
                    throw new ParseException(getPosition(), ParseException.ERROR_UNEXPECTED_TOKEN, getToken());
                }
            }while(getToken().type!=Yytoken.TYPE_EOF);
        }
        catch(IOException ie){
            throw ie;
        }

        throw new ParseException(getPosition(), ParseException.ERROR_UNEXPECTED_TOKEN, getToken());
    }

    private void nextToken() throws ParseException, IOException{
        token = lexer.yylex();
        if(getToken() == null)
            token = new Yytoken(Yytoken.TYPE_EOF, null);
    }

    private Map createObjectContainer(ContainerFactory containerFactory){
        if(containerFactory == null)
            return new JSONObject();
        Map m = containerFactory.createObjectContainer();

        if(m == null)
            return new JSONObject();
        return m;
    }

    private List createArrayContainer(ContainerFactory containerFactory){
        if(containerFactory == null)
            return new JSONArray();
        List l = containerFactory.createArrayContainer();

        if(l == null)
            return new JSONArray();
        return l;
    }

    public void parse(String s, ContentHandler contentHandler) throws ParseException{
        parse(s, contentHandler, false);
    }

    public void parse(String s, ContentHandler contentHandler, boolean isResume) throws ParseException{
        StringReader in=new StringReader(s);
        try{
            parse(in, contentHandler, isResume);
        }
        catch(IOException ie){
                        /*
                         * Actually it will never happen.
                         */
            throw new ParseException(-1, ParseException.ERROR_UNEXPECTED_EXCEPTION, ie);
        }
    }

    public void parse(Reader in, ContentHandler contentHandler) throws IOException, ParseException{
        parse(in, contentHandler, false);
    }

    /**
     * Stream processing of JSON text.
     *
     * @see ContentHandler
     *
     * @param in
     * @param contentHandler
     * @param isResume - Indicates if it continues previous parsing operation.
     *                   If set to true, resume parsing the old stream, and parameter 'in' will be ignored.
     *                   If this method is called for the first time in this instance, isResume will be ignored.
     *
     * @throws IOException
     * @throws ParseException
     */
    public void parse(Reader in, ContentHandler contentHandler, boolean isResume) throws IOException, ParseException{
        if(!isResume){
            reset(in);
            handlerStatusStack = new LinkedList();
        }
        else{
            if(handlerStatusStack == null){
                isResume = false;
                reset(in);
                handlerStatusStack = new LinkedList();
            }
        }

        LinkedList statusStack = handlerStatusStack;

        try{
            do{
                switch(getStatus()){
                    case S_INIT:
                        contentHandler.startJSON();
                        nextToken();
                        switch(getToken().type){
                            case Yytoken.TYPE_VALUE:
                                status=S_IN_FINISHED_VALUE;
                                statusStack.addFirst(new Integer(getStatus()));
                                if(!contentHandler.primitive(getToken().value))
                                    return;
                                break;
                            case Yytoken.TYPE_LEFT_BRACE:
                                status=S_IN_OBJECT;
                                statusStack.addFirst(new Integer(getStatus()));
                                if(!contentHandler.startObject())
                                    return;
                                break;
                            case Yytoken.TYPE_LEFT_SQUARE:
                                status=S_IN_ARRAY;
                                statusStack.addFirst(new Integer(getStatus()));
                                if(!contentHandler.startArray())
                                    return;
                                break;
                            default:
                                status=S_IN_ERROR;
                        }//inner switch
                        break;

                    case S_IN_FINISHED_VALUE:
                        nextToken();
                        if(getToken().type==Yytoken.TYPE_EOF){
                            contentHandler.endJSON();
                            status = S_END;
                            return;
                        }
                        else{
                            status = S_IN_ERROR;
                            throw new ParseException(getPosition(), ParseException.ERROR_UNEXPECTED_TOKEN, getToken());
                        }

                    case S_IN_OBJECT:
                        nextToken();
                        switch(getToken().type){
                            case Yytoken.TYPE_COMMA:
                                break;
                            case Yytoken.TYPE_VALUE:
                                if(getToken().value instanceof String){
                                    String key=(String)getToken().value;
                                    status=S_PASSED_PAIR_KEY;
                                    statusStack.addFirst(new Integer(getStatus()));
                                    if(!contentHandler.startObjectEntry(key))
                                        return;
                                }
                                else{
                                    status=S_IN_ERROR;
                                }
                                break;
                            case Yytoken.TYPE_RIGHT_BRACE:
                                if(statusStack.size()>1){
                                    statusStack.removeFirst();
                                    status=peekStatus(statusStack);
                                }
                                else{
                                    status=S_IN_FINISHED_VALUE;
                                }
                                if(!contentHandler.endObject())
                                    return;
                                break;
                            default:
                                status=S_IN_ERROR;
                                break;
                        }//inner switch
                        break;

                    case S_PASSED_PAIR_KEY:
                        nextToken();
                        switch(getToken().type){
                            case Yytoken.TYPE_COLON:
                                break;
                            case Yytoken.TYPE_VALUE:
                                statusStack.removeFirst();
                                status=peekStatus(statusStack);
                                if(!contentHandler.primitive(getToken().value))
                                    return;
                                if(!contentHandler.endObjectEntry())
                                    return;
                                break;
                            case Yytoken.TYPE_LEFT_SQUARE:
                                statusStack.removeFirst();
                                statusStack.addFirst(new Integer(S_IN_PAIR_VALUE));
                                status=S_IN_ARRAY;
                                statusStack.addFirst(new Integer(getStatus()));
                                if(!contentHandler.startArray())
                                    return;
                                break;
                            case Yytoken.TYPE_LEFT_BRACE:
                                statusStack.removeFirst();
                                statusStack.addFirst(new Integer(S_IN_PAIR_VALUE));
                                status=S_IN_OBJECT;
                                statusStack.addFirst(new Integer(getStatus()));
                                if(!contentHandler.startObject())
                                    return;
                                break;
                            default:
                                status=S_IN_ERROR;
                        }
                        break;

                    case S_IN_PAIR_VALUE:
                                        /*
                                         * S_IN_PAIR_VALUE is just a marker to indicate the end of an object entry, it doesn't proccess any token,
                                         * therefore delay consuming token until next round.
                                         */
                        statusStack.removeFirst();
                        status = peekStatus(statusStack);
                        if(!contentHandler.endObjectEntry())
                            return;
                        break;

                    case S_IN_ARRAY:
                        nextToken();
                        switch(getToken().type){
                            case Yytoken.TYPE_COMMA:
                                break;
                            case Yytoken.TYPE_VALUE:
                                if(!contentHandler.primitive(getToken().value))
                                    return;
                                break;
                            case Yytoken.TYPE_RIGHT_SQUARE:
                                if(statusStack.size()>1){
                                    statusStack.removeFirst();
                                    status=peekStatus(statusStack);
                                }
                                else{
                                    status=S_IN_FINISHED_VALUE;
                                }
                                if(!contentHandler.endArray())
                                    return;
                                break;
                            case Yytoken.TYPE_LEFT_BRACE:
                                status=S_IN_OBJECT;
                                statusStack.addFirst(new Integer(getStatus()));
                                if(!contentHandler.startObject())
                                    return;
                                break;
                            case Yytoken.TYPE_LEFT_SQUARE:
                                status=S_IN_ARRAY;
                                statusStack.addFirst(new Integer(getStatus()));
                                if(!contentHandler.startArray())
                                    return;
                                break;
                            default:
                                status=S_IN_ERROR;
                        }//inner switch
                        break;

                    case S_END:
                        return;

                    case S_IN_ERROR:
                        throw new ParseException(getPosition(), ParseException.ERROR_UNEXPECTED_TOKEN, getToken());
                }//switch
                if(status==S_IN_ERROR){
                    throw new ParseException(getPosition(), ParseException.ERROR_UNEXPECTED_TOKEN, getToken());
                }
            }while(getToken().type!=Yytoken.TYPE_EOF);
        }
        catch(IOException ie){
            status = S_IN_ERROR;
            throw ie;
        }
        catch(ParseException pe){
            status = S_IN_ERROR;
            throw pe;
        }
        catch(RuntimeException re){
            status = S_IN_ERROR;
            throw re;
        }
        catch(Error e){
            status = S_IN_ERROR;
            throw e;
        }

        status = S_IN_ERROR;
        throw new ParseException(getPosition(), ParseException.ERROR_UNEXPECTED_TOKEN, getToken());
    }
}