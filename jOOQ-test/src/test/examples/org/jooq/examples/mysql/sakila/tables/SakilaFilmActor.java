/**
 * This class is generated by jOOQ
 */
package org.jooq.examples.mysql.sakila.tables;

/**
 * This class is generated by jOOQ.
 */
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SakilaFilmActor extends org.jooq.impl.TableImpl<org.jooq.examples.mysql.sakila.tables.records.SakilaFilmActorRecord> {

	private static final long serialVersionUID = -256666347;

	/**
	 * The singleton instance of <code>sakila.film_actor</code>
	 */
	public static final org.jooq.examples.mysql.sakila.tables.SakilaFilmActor FILM_ACTOR = new org.jooq.examples.mysql.sakila.tables.SakilaFilmActor();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<org.jooq.examples.mysql.sakila.tables.records.SakilaFilmActorRecord> getRecordType() {
		return org.jooq.examples.mysql.sakila.tables.records.SakilaFilmActorRecord.class;
	}

	/**
	 * The column <code>sakila.film_actor.actor_id</code>. 
	 */
	public final org.jooq.TableField<org.jooq.examples.mysql.sakila.tables.records.SakilaFilmActorRecord, java.lang.Short> ACTOR_ID = createField("actor_id", org.jooq.impl.SQLDataType.SMALLINT.nullable(false), this);

	/**
	 * The column <code>sakila.film_actor.film_id</code>. 
	 */
	public final org.jooq.TableField<org.jooq.examples.mysql.sakila.tables.records.SakilaFilmActorRecord, java.lang.Short> FILM_ID = createField("film_id", org.jooq.impl.SQLDataType.SMALLINT.nullable(false), this);

	/**
	 * The column <code>sakila.film_actor.last_update</code>. 
	 */
	public final org.jooq.TableField<org.jooq.examples.mysql.sakila.tables.records.SakilaFilmActorRecord, java.sql.Timestamp> LAST_UPDATE = createField("last_update", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaulted(true), this);

	/**
	 * Create a <code>sakila.film_actor</code> table reference
	 */
	public SakilaFilmActor() {
		super("film_actor", org.jooq.examples.mysql.sakila.SakilaSakila.SAKILA);
	}

	/**
	 * Create an aliased <code>sakila.film_actor</code> table reference
	 */
	public SakilaFilmActor(java.lang.String alias) {
		super(alias, org.jooq.examples.mysql.sakila.SakilaSakila.SAKILA, org.jooq.examples.mysql.sakila.tables.SakilaFilmActor.FILM_ACTOR);
	}

	private SakilaFilmActor(java.lang.String alias, org.jooq.Table<org.jooq.examples.mysql.sakila.tables.records.SakilaFilmActorRecord> aliased) {
		super(alias, org.jooq.examples.mysql.sakila.SakilaSakila.SAKILA, aliased);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<org.jooq.examples.mysql.sakila.tables.records.SakilaFilmActorRecord> getPrimaryKey() {
		return org.jooq.examples.mysql.sakila.Keys.KEY_FILM_ACTOR_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<org.jooq.examples.mysql.sakila.tables.records.SakilaFilmActorRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<org.jooq.examples.mysql.sakila.tables.records.SakilaFilmActorRecord>>asList(org.jooq.examples.mysql.sakila.Keys.KEY_FILM_ACTOR_PRIMARY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.ForeignKey<org.jooq.examples.mysql.sakila.tables.records.SakilaFilmActorRecord, ?>> getReferences() {
		return java.util.Arrays.<org.jooq.ForeignKey<org.jooq.examples.mysql.sakila.tables.records.SakilaFilmActorRecord, ?>>asList(org.jooq.examples.mysql.sakila.Keys.FK_FILM_ACTOR_ACTOR, org.jooq.examples.mysql.sakila.Keys.FK_FILM_ACTOR_FILM);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.examples.mysql.sakila.tables.SakilaFilmActor as(java.lang.String alias) {
		return new org.jooq.examples.mysql.sakila.tables.SakilaFilmActor(alias, this);
	}

	/**
	 * Rename this table
	 */
	public org.jooq.examples.mysql.sakila.tables.SakilaFilmActor rename(java.lang.String name) {
		return new org.jooq.examples.mysql.sakila.tables.SakilaFilmActor(name, null);
	}
}