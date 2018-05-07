







package org.jooq.util.xml.jaxb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="catalogs" type="{http://www.jooq.org/xsd/jooq-meta-3.11.0.xsd}Catalogs" minOccurs="0"/&gt;
 *         &lt;element name="schemata" type="{http://www.jooq.org/xsd/jooq-meta-3.11.0.xsd}Schemata" minOccurs="0"/&gt;
 *         &lt;element name="sequences" type="{http://www.jooq.org/xsd/jooq-meta-3.11.0.xsd}Sequences" minOccurs="0"/&gt;
 *         &lt;element name="tables" type="{http://www.jooq.org/xsd/jooq-meta-3.11.0.xsd}Tables" minOccurs="0"/&gt;
 *         &lt;element name="columns" type="{http://www.jooq.org/xsd/jooq-meta-3.11.0.xsd}Columns" minOccurs="0"/&gt;
 *         &lt;element name="table_constraints" type="{http://www.jooq.org/xsd/jooq-meta-3.11.0.xsd}TableConstraints" minOccurs="0"/&gt;
 *         &lt;element name="key_column_usages" type="{http://www.jooq.org/xsd/jooq-meta-3.11.0.xsd}KeyColumnUsages" minOccurs="0"/&gt;
 *         &lt;element name="referential_constraints" type="{http://www.jooq.org/xsd/jooq-meta-3.11.0.xsd}ReferentialConstraints" minOccurs="0"/&gt;
 *         &lt;element name="indexes" type="{http://www.jooq.org/xsd/jooq-meta-3.11.0.xsd}Indexes" minOccurs="0"/&gt;
 *         &lt;element name="index_column_usages" type="{http://www.jooq.org/xsd/jooq-meta-3.11.0.xsd}IndexColumnUsages" minOccurs="0"/&gt;
 *         &lt;element name="routines" type="{http://www.jooq.org/xsd/jooq-meta-3.11.0.xsd}Routines" minOccurs="0"/&gt;
 *         &lt;element name="parameters" type="{http://www.jooq.org/xsd/jooq-meta-3.11.0.xsd}Parameters" minOccurs="0"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {

})
@XmlRootElement(name = "information_schema")
@SuppressWarnings({
    "all"
})
public class InformationSchema implements Serializable
{

    private final static long serialVersionUID = 31100L;
    @XmlElementWrapper(name = "catalogs")
    @XmlElement(name = "catalog")
    protected List<Catalog> catalogs;
    @XmlElementWrapper(name = "schemata")
    @XmlElement(name = "schema")
    protected List<Schema> schemata;
    @XmlElementWrapper(name = "sequences")
    @XmlElement(name = "sequence")
    protected List<Sequence> sequences;
    @XmlElementWrapper(name = "tables")
    @XmlElement(name = "table")
    protected List<Table> tables;
    @XmlElementWrapper(name = "columns")
    @XmlElement(name = "column")
    protected List<Column> columns;
    @XmlElementWrapper(name = "table_constraints")
    @XmlElement(name = "table_constraint")
    protected List<TableConstraint> tableConstraints;
    @XmlElementWrapper(name = "key_column_usages")
    @XmlElement(name = "key_column_usage")
    protected List<KeyColumnUsage> keyColumnUsages;
    @XmlElementWrapper(name = "referential_constraints")
    @XmlElement(name = "referential_constraint")
    protected List<ReferentialConstraint> referentialConstraints;
    @XmlElementWrapper(name = "indexes")
    @XmlElement(name = "index")
    protected List<Index> indexes;
    @XmlElementWrapper(name = "index_column_usages")
    @XmlElement(name = "index_column_usage")
    protected List<IndexColumnUsage> indexColumnUsages;
    @XmlElementWrapper(name = "routines")
    @XmlElement(name = "routine")
    protected List<Routine> routines;
    @XmlElementWrapper(name = "parameters")
    @XmlElement(name = "parameter")
    protected List<Parameter> parameters;

    public List<Catalog> getCatalogs() {
        if (catalogs == null) {
            catalogs = new ArrayList<Catalog>();
        }
        return catalogs;
    }

    public void setCatalogs(List<Catalog> catalogs) {
        this.catalogs = catalogs;
    }

    public List<Schema> getSchemata() {
        if (schemata == null) {
            schemata = new ArrayList<Schema>();
        }
        return schemata;
    }

    public void setSchemata(List<Schema> schemata) {
        this.schemata = schemata;
    }

    public List<Sequence> getSequences() {
        if (sequences == null) {
            sequences = new ArrayList<Sequence>();
        }
        return sequences;
    }

    public void setSequences(List<Sequence> sequences) {
        this.sequences = sequences;
    }

    public List<Table> getTables() {
        if (tables == null) {
            tables = new ArrayList<Table>();
        }
        return tables;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }

    public List<Column> getColumns() {
        if (columns == null) {
            columns = new ArrayList<Column>();
        }
        return columns;
    }

    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }

    public List<TableConstraint> getTableConstraints() {
        if (tableConstraints == null) {
            tableConstraints = new ArrayList<TableConstraint>();
        }
        return tableConstraints;
    }

    public void setTableConstraints(List<TableConstraint> tableConstraints) {
        this.tableConstraints = tableConstraints;
    }

    public List<KeyColumnUsage> getKeyColumnUsages() {
        if (keyColumnUsages == null) {
            keyColumnUsages = new ArrayList<KeyColumnUsage>();
        }
        return keyColumnUsages;
    }

    public void setKeyColumnUsages(List<KeyColumnUsage> keyColumnUsages) {
        this.keyColumnUsages = keyColumnUsages;
    }

    public List<ReferentialConstraint> getReferentialConstraints() {
        if (referentialConstraints == null) {
            referentialConstraints = new ArrayList<ReferentialConstraint>();
        }
        return referentialConstraints;
    }

    public void setReferentialConstraints(List<ReferentialConstraint> referentialConstraints) {
        this.referentialConstraints = referentialConstraints;
    }

    public List<Index> getIndexes() {
        if (indexes == null) {
            indexes = new ArrayList<Index>();
        }
        return indexes;
    }

    public void setIndexes(List<Index> indexes) {
        this.indexes = indexes;
    }

    public List<IndexColumnUsage> getIndexColumnUsages() {
        if (indexColumnUsages == null) {
            indexColumnUsages = new ArrayList<IndexColumnUsage>();
        }
        return indexColumnUsages;
    }

    public void setIndexColumnUsages(List<IndexColumnUsage> indexColumnUsages) {
        this.indexColumnUsages = indexColumnUsages;
    }

    public List<Routine> getRoutines() {
        if (routines == null) {
            routines = new ArrayList<Routine>();
        }
        return routines;
    }

    public void setRoutines(List<Routine> routines) {
        this.routines = routines;
    }

    public List<Parameter> getParameters() {
        if (parameters == null) {
            parameters = new ArrayList<Parameter>();
        }
        return parameters;
    }

    public void setParameters(List<Parameter> parameters) {
        this.parameters = parameters;
    }

    public InformationSchema withCatalogs(Catalog... values) {
        if (values!= null) {
            for (Catalog value: values) {
                getCatalogs().add(value);
            }
        }
        return this;
    }

    public InformationSchema withCatalogs(Collection<Catalog> values) {
        if (values!= null) {
            getCatalogs().addAll(values);
        }
        return this;
    }

    public InformationSchema withCatalogs(List<Catalog> catalogs) {
        setCatalogs(catalogs);
        return this;
    }

    public InformationSchema withSchemata(Schema... values) {
        if (values!= null) {
            for (Schema value: values) {
                getSchemata().add(value);
            }
        }
        return this;
    }

    public InformationSchema withSchemata(Collection<Schema> values) {
        if (values!= null) {
            getSchemata().addAll(values);
        }
        return this;
    }

    public InformationSchema withSchemata(List<Schema> schemata) {
        setSchemata(schemata);
        return this;
    }

    public InformationSchema withSequences(Sequence... values) {
        if (values!= null) {
            for (Sequence value: values) {
                getSequences().add(value);
            }
        }
        return this;
    }

    public InformationSchema withSequences(Collection<Sequence> values) {
        if (values!= null) {
            getSequences().addAll(values);
        }
        return this;
    }

    public InformationSchema withSequences(List<Sequence> sequences) {
        setSequences(sequences);
        return this;
    }

    public InformationSchema withTables(Table... values) {
        if (values!= null) {
            for (Table value: values) {
                getTables().add(value);
            }
        }
        return this;
    }

    public InformationSchema withTables(Collection<Table> values) {
        if (values!= null) {
            getTables().addAll(values);
        }
        return this;
    }

    public InformationSchema withTables(List<Table> tables) {
        setTables(tables);
        return this;
    }

    public InformationSchema withColumns(Column... values) {
        if (values!= null) {
            for (Column value: values) {
                getColumns().add(value);
            }
        }
        return this;
    }

    public InformationSchema withColumns(Collection<Column> values) {
        if (values!= null) {
            getColumns().addAll(values);
        }
        return this;
    }

    public InformationSchema withColumns(List<Column> columns) {
        setColumns(columns);
        return this;
    }

    public InformationSchema withTableConstraints(TableConstraint... values) {
        if (values!= null) {
            for (TableConstraint value: values) {
                getTableConstraints().add(value);
            }
        }
        return this;
    }

    public InformationSchema withTableConstraints(Collection<TableConstraint> values) {
        if (values!= null) {
            getTableConstraints().addAll(values);
        }
        return this;
    }

    public InformationSchema withTableConstraints(List<TableConstraint> tableConstraints) {
        setTableConstraints(tableConstraints);
        return this;
    }

    public InformationSchema withKeyColumnUsages(KeyColumnUsage... values) {
        if (values!= null) {
            for (KeyColumnUsage value: values) {
                getKeyColumnUsages().add(value);
            }
        }
        return this;
    }

    public InformationSchema withKeyColumnUsages(Collection<KeyColumnUsage> values) {
        if (values!= null) {
            getKeyColumnUsages().addAll(values);
        }
        return this;
    }

    public InformationSchema withKeyColumnUsages(List<KeyColumnUsage> keyColumnUsages) {
        setKeyColumnUsages(keyColumnUsages);
        return this;
    }

    public InformationSchema withReferentialConstraints(ReferentialConstraint... values) {
        if (values!= null) {
            for (ReferentialConstraint value: values) {
                getReferentialConstraints().add(value);
            }
        }
        return this;
    }

    public InformationSchema withReferentialConstraints(Collection<ReferentialConstraint> values) {
        if (values!= null) {
            getReferentialConstraints().addAll(values);
        }
        return this;
    }

    public InformationSchema withReferentialConstraints(List<ReferentialConstraint> referentialConstraints) {
        setReferentialConstraints(referentialConstraints);
        return this;
    }

    public InformationSchema withIndexes(Index... values) {
        if (values!= null) {
            for (Index value: values) {
                getIndexes().add(value);
            }
        }
        return this;
    }

    public InformationSchema withIndexes(Collection<Index> values) {
        if (values!= null) {
            getIndexes().addAll(values);
        }
        return this;
    }

    public InformationSchema withIndexes(List<Index> indexes) {
        setIndexes(indexes);
        return this;
    }

    public InformationSchema withIndexColumnUsages(IndexColumnUsage... values) {
        if (values!= null) {
            for (IndexColumnUsage value: values) {
                getIndexColumnUsages().add(value);
            }
        }
        return this;
    }

    public InformationSchema withIndexColumnUsages(Collection<IndexColumnUsage> values) {
        if (values!= null) {
            getIndexColumnUsages().addAll(values);
        }
        return this;
    }

    public InformationSchema withIndexColumnUsages(List<IndexColumnUsage> indexColumnUsages) {
        setIndexColumnUsages(indexColumnUsages);
        return this;
    }

    public InformationSchema withRoutines(Routine... values) {
        if (values!= null) {
            for (Routine value: values) {
                getRoutines().add(value);
            }
        }
        return this;
    }

    public InformationSchema withRoutines(Collection<Routine> values) {
        if (values!= null) {
            getRoutines().addAll(values);
        }
        return this;
    }

    public InformationSchema withRoutines(List<Routine> routines) {
        setRoutines(routines);
        return this;
    }

    public InformationSchema withParameters(Parameter... values) {
        if (values!= null) {
            for (Parameter value: values) {
                getParameters().add(value);
            }
        }
        return this;
    }

    public InformationSchema withParameters(Collection<Parameter> values) {
        if (values!= null) {
            getParameters().addAll(values);
        }
        return this;
    }

    public InformationSchema withParameters(List<Parameter> parameters) {
        setParameters(parameters);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (getCatalogs() != null) {
            sb.append("<catalogs>");
            sb.append(getCatalogs());
            sb.append("</catalogs>");
        }
        if (getSchemata() != null) {
            sb.append("<schemata>");
            sb.append(getSchemata());
            sb.append("</schemata>");
        }
        if (getSequences()!= null) {
            sb.append("<sequences>");
            sb.append(getSequences());
            sb.append("</sequences>");
        }
        if (getTables() != null) {
            sb.append("<tables>");
            sb.append(getTables());
            sb.append("</tables>");
        }
        if (getColumns() != null) {
            sb.append("<columns>");
            sb.append(getColumns());
            sb.append("</columns>");
        }
        if (getTableConstraints() != null) {
            sb.append("<tableConstraints>");
            sb.append(getTableConstraints());
            sb.append("</tableConstraints>");
        }
        if (getKeyColumnUsages() != null) {
            sb.append("<keyColumnUsages>");
            sb.append(getKeyColumnUsages());
            sb.append("</keyColumnUsages>");
        }
        if (getReferentialConstraints()!= null) {
            sb.append("<referentialConstraints>");
            sb.append(getReferentialConstraints());
            sb.append("</referentialConstraints>");
        }
        if (getIndexes()!= null) {
            sb.append("<indexes>");
            sb.append(getIndexes());
            sb.append("</indexes>");
        }
        if (getIndexColumnUsages()!= null) {
            sb.append("<indexColumnUsages>");
            sb.append(getIndexColumnUsages());
            sb.append("</indexColumnUsages>");
        }
        if (getRoutines() != null) {
            sb.append("<routines>");
            sb.append(getRoutines());
            sb.append("</routines>");
        }
        if (getParameters()!= null) {
            sb.append("<parameters>");
            sb.append(getParameters());
            sb.append("</parameters>");
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
    	boolean objectNull;
        boolean otherObjectNotNull;
        boolean EqualWithOther;
        
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass()!= that.getClass()) {
            return false;
        }
        InformationSchema other = ((InformationSchema) that);
        objectNull = catalogs == null;
        otherObjectNotNull = other.catalogs != null;
        EqualWithOther = catalogs.equals(other.catalogs);
        if( (objectNull && otherObjectNotNull) || !objectNull && !EqualWithOther) {
        	return false;
        }
        objectNull = schemata == null;
        otherObjectNotNull = other.schemata != null;
        EqualWithOther = schemata.equals(other.schemata);
        if( (objectNull && otherObjectNotNull) || !objectNull && !EqualWithOther) {
        	return false;
        }
        objectNull = sequences == null;
        otherObjectNotNull = other.sequences != null;
        EqualWithOther = sequences.equals(other.sequences);
        if( (objectNull && otherObjectNotNull) || !objectNull && !EqualWithOther) {
        	return false;
        }
        objectNull = tables == null;
        otherObjectNotNull = other.tables != null;
        EqualWithOther = tables.equals(other.tables);
        if( (objectNull && otherObjectNotNull) || !objectNull && !EqualWithOther) {
        	return false;
        }
        objectNull = columns == null;
        otherObjectNotNull = other.columns != null;
        EqualWithOther = columns.equals(other.columns);
        if( (objectNull && otherObjectNotNull) || !objectNull && !EqualWithOther) {
        	return false;
        }
        objectNull = tableConstraints == null;
        otherObjectNotNull = other.tableConstraints != null;
        EqualWithOther = tableConstraints.equals(other.tableConstraints);
        if( (objectNull && otherObjectNotNull) || !objectNull && !EqualWithOther) {
        	return false;
        }
        objectNull = keyColumnUsages == null;
        otherObjectNotNull = other.keyColumnUsages != null;
        EqualWithOther = keyColumnUsages.equals(other.keyColumnUsages);
        if( (objectNull && otherObjectNotNull) || !objectNull && !EqualWithOther) {
        	return false;
        }
        objectNull = referentialConstraints == null;
        otherObjectNotNull = other.referentialConstraints != null;
        EqualWithOther = referentialConstraints.equals(other.referentialConstraints);
        if( (objectNull && otherObjectNotNull) || !objectNull && !EqualWithOther) {
        	return false;
        }
        objectNull = indexes == null;
        otherObjectNotNull = other.indexes != null;
        EqualWithOther = indexes.equals(other.indexes);
        if( (objectNull && otherObjectNotNull) || !objectNull && !EqualWithOther) {
        	return false;
        }
        objectNull = indexColumnUsages == null;
        otherObjectNotNull = other.indexColumnUsages != null;
        EqualWithOther = indexColumnUsages.equals(other.indexColumnUsages);
        if( (objectNull && otherObjectNotNull) || !objectNull && !EqualWithOther) {
        	return false;
        }
        objectNull = routines == null;
        otherObjectNotNull = other.routines != null;
        EqualWithOther = routines.equals(other.routines);
        if( (objectNull && otherObjectNotNull) || !objectNull && !EqualWithOther) {
        	return false;
        } 
        objectNull = parameters == null;
        otherObjectNotNull = other.parameters != null;
        EqualWithOther = parameters.equals(other.parameters);
        if( (objectNull && otherObjectNotNull) || !objectNull && !EqualWithOther) {
        	return false;
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = ((prime*result)+((catalogs == null)? 0 :catalogs.hashCode()));
        result = ((prime*result)+((schemata == null)? 0 :schemata.hashCode()));
        result = ((prime*result)+((sequences == null)? 0 :sequences.hashCode()));
        result = ((prime*result)+((tables == null)? 0 :tables.hashCode()));
        result = ((prime*result)+((columns == null)? 0 :columns.hashCode()));
        result = ((prime*result)+((tableConstraints == null)? 0 :tableConstraints.hashCode()));
        result = ((prime*result)+((keyColumnUsages == null)? 0 :keyColumnUsages.hashCode()));
        result = ((prime*result)+((referentialConstraints == null)? 0 :referentialConstraints.hashCode()));
        result = ((prime*result)+((indexes == null)? 0 :indexes.hashCode()));
        result = ((prime*result)+((indexColumnUsages == null)? 0 :indexColumnUsages.hashCode()));
        result = ((prime*result)+((routines == null)? 0 :routines.hashCode()));
        result = ((prime*result)+((parameters == null)? 0 :parameters.hashCode()));
        return result;
    }

}
