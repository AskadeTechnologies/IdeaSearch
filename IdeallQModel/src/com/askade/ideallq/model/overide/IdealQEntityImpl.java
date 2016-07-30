package com.askade.ideallq.model.overide;


import java.math.BigDecimal;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Types;

import oracle.jbo.AttributeDef;
import oracle.jbo.AttributeList;
import oracle.jbo.server.DBTransaction;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.TransactionEvent;

public class IdealQEntityImpl extends EntityImpl {
    public IdealQEntityImpl() {
        super();
    }
/*
    @Override
    protected void doDML(int i, TransactionEvent transactionEvent) {
        //got to call first to super, so the record is posted
        //and we can then ask for the last insert id
        super.doDML(i, transactionEvent);

        //after the record is inserted, we can ask for the last insert id
        if (i == DML_INSERT) {
            populateAutoincrementAtt();
        }
    }
*/
    /*
        * Determines if the Entity PK is marked as an autoincrement col
        * and executes a MySQL function to retrieve the last insert id
        */
    /*
    private void populateAutoincrementAtt() {
        EntityDefImpl entdef = this.getEntityDef();
        AttributeDef pk = null;
        //look for primary key with Autoincrement property set
        for (AttributeDef att : entdef.getAttributeDefs()) {
            if (att.isPrimaryKey() &&
                (att.getProperty("AI") != null && new Boolean(att.getProperty("AI").toString()))) {
                pk = att;
                break;
            }
        }
        if (pk != null) {
            try (PreparedStatement stmt =
                 this.getDBTransaction().createPreparedStatement("SELECT last_insert_id()", 1)) {
                stmt.execute();
                try (ResultSet rs = stmt.getResultSet()) {
                    if (rs.next()) {
                        setAttribute(pk.getName(), new BigDecimal(rs.getInt(1)));
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }*/
    
    @Override
    protected void create(AttributeList attributeList) {
        super.create(attributeList);
        for (AttributeDef def : getEntityDef().getAttributeDefs()) {
            String sequenceName = (String) def.getProperty("SequenceName");
            if (sequenceName != null) {
                DBTransaction transaction = getDBTransaction();
                String getSequenceString = "{call "+sequenceName+"(?)}";
                CallableStatement callableStatement = transaction.createCallableStatement(getSequenceString, DBTransaction.DEFAULT);
                try {
                    callableStatement.registerOutParameter(1, Types.BIGINT);
                    callableStatement.executeUpdate();
                    setAttribute(def.getIndex(), callableStatement.getBigDecimal(1));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
