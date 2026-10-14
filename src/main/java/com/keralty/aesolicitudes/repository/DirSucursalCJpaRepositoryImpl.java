package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.exception.SystemException;
import com.keralty.aesolicitudes.global.DirSucursalCConstants;
import com.keralty.aesolicitudes.global.TelefonoCConstants;
import com.keralty.aesolicitudes.global.UserFunctions;
import com.keralty.aesolicitudes.persistence.DirSucursalC;
import com.keralty.aesolicitudes.persistence.TelefonoC;
import com.keralty.aesolicitudes.sqlutils.SQLExists;
import com.keralty.aesolicitudes.sqlutils.SQLParam;
import com.keralty.aesolicitudes.sqlutils.SQLPopulation;
import com.keralty.aesolicitudes.sqlutils.SQLSelect;
import com.keralty.aesolicitudes.sqlutils.TypedQueryBuilder;
import com.keralty.aesolicitudes.utils.Agent;
import jakarta.inject.Inject;
import java.util.Collection;
import java.util.List;

public class DirSucursalCJpaRepositoryImpl extends AbstractRepository implements DirSucursalCJpaRepositoryCustom {

    @Inject
    public DirSucursalCJpaRepositoryImpl(Agent agent, UserFunctions userFunctionsSrv) {
        super(agent, userFunctionsSrv);
    }

    @Override
    public List<DirSucursalC> executeQuery(String jpqlQuery) {
        return getQueryBuilder().build(jpqlQuery).execute();
    }
    
    @Override
    public List<DirSucursalC> executeQuery(String jpqlQuery, List<SQLParam> params) {
        return getQueryBuilder().build(jpqlQuery).setParameters(params).execute();
    }
    
    public Collection<DirSucursalC> executeQuery(SQLSelect select) {
        return getQueryBuilder().build(select).execute();
    }

    private TypedQueryBuilder<DirSucursalC> getQueryBuilder() {
        return new TypedQueryBuilder<>(em, DirSucursalC.class);
    }
    
    public List<DirSucursalC> solveQuery(SQLSelect select) {
        return solveQuery(select, 0, 0);
    }

    public List<DirSucursalC> solveQuery(SQLSelect select, int pageSize, int pageNumber) {
        return getQueryBuilder().build(select, pageSize, pageNumber).execute();
    }

    // AssocOperator: AssocOperator000
    public Boolean assocOperator000(DirSucursalC instance) throws SystemException {
        try {
            // EXIST (DepartamentoC)
            return assocOperator000Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: DirSucursalC, Assoc.Operator: AssocOperator000, Method: assocOperator000";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator000
    public Boolean assocOperator000Range1 (DirSucursalC instance) throws SystemException {
        SQLExists sql = assocOperator000Range1Query(instance);
        return !new TypedQueryBuilder<DirSucursalC>(em, DirSucursalC.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator000
    public SQLExists assocOperator000Range1Query (DirSucursalC instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(DirSucursalCConstants.CLASS_NAME, DirSucursalCConstants.ROLE_NAME_DEPARTAMENTOC, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: DirSucursalC, Assoc.Operator: AssocOperator000, Method: assocOperator000Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator001
    public Boolean assocOperator001(DirSucursalC instance) throws SystemException {
        try {
            // EXIST (DepartamentoC)
            return assocOperator001Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: DirSucursalC, Assoc.Operator: AssocOperator001, Method: assocOperator001";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator001
    public Boolean assocOperator001Range1 (DirSucursalC instance) throws SystemException {
        SQLExists sql = assocOperator001Range1Query(instance);
        return !new TypedQueryBuilder<DirSucursalC>(em, DirSucursalC.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator001
    public SQLExists assocOperator001Range1Query (DirSucursalC instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(DirSucursalCConstants.CLASS_NAME, DirSucursalCConstants.ROLE_NAME_DEPARTAMENTOC, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: DirSucursalC, Assoc.Operator: AssocOperator001, Method: assocOperator001Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator003
    public Boolean assocOperator003(DirSucursalC instance) throws SystemException {
        try {
            // EXIST (MunicipioC)
            return assocOperator003Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: DirSucursalC, Assoc.Operator: AssocOperator003, Method: assocOperator003";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator003
    public Boolean assocOperator003Range1 (DirSucursalC instance) throws SystemException {
        SQLExists sql = assocOperator003Range1Query(instance);
        return !new TypedQueryBuilder<DirSucursalC>(em, DirSucursalC.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator003
    public SQLExists assocOperator003Range1Query (DirSucursalC instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(DirSucursalCConstants.CLASS_NAME, DirSucursalCConstants.ROLE_NAME_MUNICIPIOC, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: DirSucursalC, Assoc.Operator: AssocOperator003, Method: assocOperator003Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator004
    public Boolean assocOperator004(DirSucursalC instance) throws SystemException {
        try {
            // EXIST (MunicipioC)
            return assocOperator004Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: DirSucursalC, Assoc.Operator: AssocOperator004, Method: assocOperator004";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator004
    public Boolean assocOperator004Range1 (DirSucursalC instance) throws SystemException {
        SQLExists sql = assocOperator004Range1Query(instance);
        return !new TypedQueryBuilder<DirSucursalC>(em, DirSucursalC.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator004
    public SQLExists assocOperator004Range1Query (DirSucursalC instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(DirSucursalCConstants.CLASS_NAME, DirSucursalCConstants.ROLE_NAME_MUNICIPIOC, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: DirSucursalC, Assoc.Operator: AssocOperator004, Method: assocOperator004Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator006
    public Boolean assocOperator006(DirSucursalC instance) throws SystemException {
        try {
            // EXIST (PaisC)
            return assocOperator006Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: DirSucursalC, Assoc.Operator: AssocOperator006, Method: assocOperator006";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator006
    public Boolean assocOperator006Range1 (DirSucursalC instance) throws SystemException {
        SQLExists sql = assocOperator006Range1Query(instance);
        return !new TypedQueryBuilder<DirSucursalC>(em, DirSucursalC.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator006
    public SQLExists assocOperator006Range1Query (DirSucursalC instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(DirSucursalCConstants.CLASS_NAME, DirSucursalCConstants.ROLE_NAME_PAISC, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: DirSucursalC, Assoc.Operator: AssocOperator006, Method: assocOperator006Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator007
    public Boolean assocOperator007(DirSucursalC instance) throws SystemException {
        try {
            // EXIST (PaisC)
            return assocOperator007Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: DirSucursalC, Assoc.Operator: AssocOperator007, Method: assocOperator007";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator007
    public Boolean assocOperator007Range1 (DirSucursalC instance) throws SystemException {
        SQLExists sql = assocOperator007Range1Query(instance);
        return !new TypedQueryBuilder<DirSucursalC>(em, DirSucursalC.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator007
    public SQLExists assocOperator007Range1Query (DirSucursalC instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(DirSucursalCConstants.CLASS_NAME, DirSucursalCConstants.ROLE_NAME_PAISC, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: DirSucursalC, Assoc.Operator: AssocOperator007, Method: assocOperator007Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator009
    public Boolean assocOperator009(DirSucursalC instance) throws SystemException {
        try {
            // EXIST (DepartamentoC)
            return assocOperator009Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: DirSucursalC, Assoc.Operator: AssocOperator009, Method: assocOperator009";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator009
    public Boolean assocOperator009Range1 (DirSucursalC instance) throws SystemException {
        SQLExists sql = assocOperator009Range1Query(instance);
        return !new TypedQueryBuilder<DirSucursalC>(em, DirSucursalC.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator009
    public SQLExists assocOperator009Range1Query (DirSucursalC instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(DirSucursalCConstants.CLASS_NAME, DirSucursalCConstants.ROLE_NAME_DEPARTAMENTOC, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: DirSucursalC, Assoc.Operator: AssocOperator009, Method: assocOperator009Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator010
    public Boolean assocOperator010(DirSucursalC instance) throws SystemException {
        try {
            // EXIST (MunicipioC)
            return assocOperator010Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: DirSucursalC, Assoc.Operator: AssocOperator010, Method: assocOperator010";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator010
    public Boolean assocOperator010Range1 (DirSucursalC instance) throws SystemException {
        SQLExists sql = assocOperator010Range1Query(instance);
        return !new TypedQueryBuilder<DirSucursalC>(em, DirSucursalC.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator010
    public SQLExists assocOperator010Range1Query (DirSucursalC instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(DirSucursalCConstants.CLASS_NAME, DirSucursalCConstants.ROLE_NAME_MUNICIPIOC, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: DirSucursalC, Assoc.Operator: AssocOperator010, Method: assocOperator010Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator011
    public Boolean assocOperator011(DirSucursalC instance) throws SystemException {
        try {
            // EXIST (PaisC)
            return assocOperator011Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: DirSucursalC, Assoc.Operator: AssocOperator011, Method: assocOperator011";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator011
    public Boolean assocOperator011Range1 (DirSucursalC instance) throws SystemException {
        SQLExists sql = assocOperator011Range1Query(instance);
        return !new TypedQueryBuilder<DirSucursalC>(em, DirSucursalC.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator011
    public SQLExists assocOperator011Range1Query (DirSucursalC instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(DirSucursalCConstants.CLASS_NAME, DirSucursalCConstants.ROLE_NAME_PAISC, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: DirSucursalC, Assoc.Operator: AssocOperator011, Method: assocOperator011Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator012
    public Collection<TelefonoC> assocOperator012(DirSucursalC instance) throws SystemException {
        try {
            // FOR ALL TelefonosC DO TelefonosC.eliminar(TelefonosC)
        return assocOperator012Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: DirSucursalC, Assoc.Operator: AssocOperator012, Method: assocOperator012";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator012
    public Collection<TelefonoC> assocOperator012Range1 (DirSucursalC instance) throws SystemException {

        SQLSelect sql = assocOperator012Range1Query(instance);
        return new TypedQueryBuilder<TelefonoC>(em, TelefonoC.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator012
    public SQLPopulation assocOperator012Range1Query (DirSucursalC instance) throws SystemException {
        try {
            return new SQLPopulation(DirSucursalCConstants.CLASS_NAME, TelefonoCConstants.CLASS_NAME, instance.getOid(), DirSucursalCConstants.ROLE_NAME_TELEFONOSC);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: DirSucursalC, Assoc.Operator: AssocOperator012, Method: assocOperator012Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    public void refreshEntity(Object object) {
        super.refreshEntity(object);
    }
}
