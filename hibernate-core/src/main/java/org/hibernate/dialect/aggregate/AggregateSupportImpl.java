/*
 * SPDX-License-Identifier: LGPL-2.1-or-later
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.dialect.aggregate;

import java.util.Collections;
import java.util.List;

import org.hibernate.boot.model.relational.AuxiliaryDatabaseObject;
import org.hibernate.boot.model.relational.Namespace;
import org.hibernate.mapping.AggregateColumn;
import org.hibernate.mapping.Column;
import org.hibernate.metamodel.mapping.SelectableMapping;
import org.hibernate.metamodel.mapping.SqlTypedMapping;
import org.hibernate.type.spi.TypeConfiguration;

public class AggregateSupportImpl implements AggregateSupport {

	public static final AggregateSupport INSTANCE = new AggregateSupportImpl();

	@Override
	public String aggregateComponentCustomReadExpression(String template, String placeholder, String aggregateParentReadExpression, String columnExpression, int aggregateColumnTypeCode, SqlTypedMapping column) {
		throw new UnsupportedOperationException( "Dialect does not support aggregateComponentCustomReadExpression: " + getClass().getName() );
	}

	@Override
	public String aggregateComponentAssignmentExpression(
			String aggregateParentAssignmentExpression,
			String columnExpression,
			int aggregateColumnTypeCode,
			Column column) {
		throw new UnsupportedOperationException( "Dialect does not support aggregateComponentAssignmentExpression: " + getClass().getName() );
	}

	@Override
	public String aggregateCustomWriteExpression(
			AggregateColumn aggregateColumn,
			List<Column> aggregatedColumns) {
		return null;
	}

	@Override
	public boolean requiresAggregateCustomWriteExpressionRenderer(int aggregateSqlTypeCode) {
		throw new UnsupportedOperationException( "Dialect does not support requiresAggregateCustomWriteExpressionRenderer: " + getClass().getName() );
	}

	@Override
	public boolean preferSelectAggregateMapping(int aggregateSqlTypeCode) {
		// By default, assume the driver supports this and prefer selecting the aggregate column
		return true;
	}

	@Override
	public boolean preferBindAggregateMapping(int aggregateSqlTypeCode) {
		// By default, assume the driver supports this and prefer binding the aggregate column
		return true;
	}

	@Override
	public WriteExpressionRenderer aggregateCustomWriteExpressionRenderer(
			SelectableMapping aggregateColumn,
			SelectableMapping[] columnsToUpdate,
			TypeConfiguration typeConfiguration) {
		throw new UnsupportedOperationException( "Dialect does not support aggregateCustomWriteExpressionRenderer: " + getClass().getName() );
	}

	@Override
	public List<AuxiliaryDatabaseObject> aggregateAuxiliaryDatabaseObjects(
			Namespace namespace,
			String aggregatePath,
			AggregateColumn aggregateColumn,
			List<Column> aggregatedColumns) {
		return Collections.emptyList();
	}

	@Override
	public int aggregateComponentSqlTypeCode(int aggregateColumnSqlTypeCode, int columnSqlTypeCode) {
		return columnSqlTypeCode;
	}

	@Override
	public boolean supportsComponentCheckConstraints() {
		return true;
	}
}
