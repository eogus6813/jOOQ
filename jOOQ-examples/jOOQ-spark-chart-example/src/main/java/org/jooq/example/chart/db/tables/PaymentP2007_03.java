/*
 * This file is generated by jOOQ.
 */
package org.jooq.example.chart.db.tables;


import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.example.chart.db.Indexes;
import org.jooq.example.chart.db.Keys;
import org.jooq.example.chart.db.Public;
import org.jooq.example.chart.db.tables.records.PaymentP2007_03Record;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.0",
        "schema version:public_2"
    },
    date = "2018-04-03T12:47:15.287Z",
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class PaymentP2007_03 extends TableImpl<PaymentP2007_03Record> {

    private static final long serialVersionUID = -653005503;

    /**
     * The reference instance of <code>public.payment_p2007_03</code>
     */
    public static final PaymentP2007_03 PAYMENT_P2007_03 = new PaymentP2007_03();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<PaymentP2007_03Record> getRecordType() {
        return PaymentP2007_03Record.class;
    }

    /**
     * The column <code>public.payment_p2007_03.payment_id</code>.
     */
    public final TableField<PaymentP2007_03Record, Integer> PAYMENT_ID = createField("payment_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('payment_payment_id_seq'::regclass)", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>public.payment_p2007_03.customer_id</code>.
     */
    public final TableField<PaymentP2007_03Record, Integer> CUSTOMER_ID = createField("customer_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.payment_p2007_03.staff_id</code>.
     */
    public final TableField<PaymentP2007_03Record, Integer> STAFF_ID = createField("staff_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.payment_p2007_03.rental_id</code>.
     */
    public final TableField<PaymentP2007_03Record, Integer> RENTAL_ID = createField("rental_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.payment_p2007_03.amount</code>.
     */
    public final TableField<PaymentP2007_03Record, BigDecimal> AMOUNT = createField("amount", org.jooq.impl.SQLDataType.NUMERIC(5, 2).nullable(false), this, "");

    /**
     * The column <code>public.payment_p2007_03.payment_date</code>.
     */
    public final TableField<PaymentP2007_03Record, Timestamp> PAYMENT_DATE = createField("payment_date", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * Create a <code>public.payment_p2007_03</code> table reference
     */
    public PaymentP2007_03() {
        this(DSL.name("payment_p2007_03"), null);
    }

    /**
     * Create an aliased <code>public.payment_p2007_03</code> table reference
     */
    public PaymentP2007_03(String alias) {
        this(DSL.name(alias), PAYMENT_P2007_03);
    }

    /**
     * Create an aliased <code>public.payment_p2007_03</code> table reference
     */
    public PaymentP2007_03(Name alias) {
        this(alias, PAYMENT_P2007_03);
    }

    private PaymentP2007_03(Name alias, Table<PaymentP2007_03Record> aliased) {
        this(alias, aliased, null);
    }

    private PaymentP2007_03(Name alias, Table<PaymentP2007_03Record> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.IDX_FK_PAYMENT_P2007_03_CUSTOMER_ID, Indexes.IDX_FK_PAYMENT_P2007_03_STAFF_ID);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<PaymentP2007_03Record, Integer> getIdentity() {
        return Keys.IDENTITY_PAYMENT_P2007_03;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<PaymentP2007_03Record, ?>> getReferences() {
        return Arrays.<ForeignKey<PaymentP2007_03Record, ?>>asList(Keys.PAYMENT_P2007_03__PAYMENT_P2007_03_CUSTOMER_ID_FKEY, Keys.PAYMENT_P2007_03__PAYMENT_P2007_03_STAFF_ID_FKEY, Keys.PAYMENT_P2007_03__PAYMENT_P2007_03_RENTAL_ID_FKEY);
    }

    public Customer customer() {
        return new Customer(this, Keys.PAYMENT_P2007_03__PAYMENT_P2007_03_CUSTOMER_ID_FKEY);
    }

    public Staff staff() {
        return new Staff(this, Keys.PAYMENT_P2007_03__PAYMENT_P2007_03_STAFF_ID_FKEY);
    }

    public Rental rental() {
        return new Rental(this, Keys.PAYMENT_P2007_03__PAYMENT_P2007_03_RENTAL_ID_FKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PaymentP2007_03 as(String alias) {
        return new PaymentP2007_03(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PaymentP2007_03 as(Name alias) {
        return new PaymentP2007_03(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public PaymentP2007_03 rename(String name) {
        return new PaymentP2007_03(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public PaymentP2007_03 rename(Name name) {
        return new PaymentP2007_03(name, null);
    }
}
