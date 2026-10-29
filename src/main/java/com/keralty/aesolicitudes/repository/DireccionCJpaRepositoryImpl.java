package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.exception.SystemException;
import com.keralty.aesolicitudes.global.DireccionCConstants;
import com.keralty.aesolicitudes.global.TelefonoCConstants;
import com.keralty.aesolicitudes.global.UserFunctions;
import com.keralty.aesolicitudes.persistence.DireccionC;
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

public class DireccionCJpaRepositoryImpl extends AbstractRepository implements DireccionCJpaRepositoryCustom {

    @Inject
    public DireccionCJpaRepositoryImpl(Agent agent, UserFunctions userFunctionsSrv) {
        super(agent, userFunctionsSrv);
    }

    @Override
    public List<DireccionC> executeQuery(String jpqlQuery) {
        return getQueryBuilder().build(jpqlQuery).execute();
    }
    
    @Override
    public List<DireccionC> executeQuery(String jpqlQuery, List<SQLParam> params) {
        return getQueryBuilder().build(jpqlQuery).setParameters(params).execute();
    }
    
    public Collection<DireccionC> executeQuery(SQLSelect select) {
        return getQueryBuilder().build(select).execute();
    }

    private TypedQueryBuilder<DireccionC> getQueryBuilder() {
        return new TypedQueryBuilder<>(em, DireccionC.class);
    }

    @Override	
    public List<DireccionC> solveQuery(SQLSelect select) {
        return solveQuery(select, 0, 0);
    }

    @Override
    public List<DireccionC> solveQuery(SQLSelect select, int pageSize, int pageNumber) {
        return getQueryBuilder().build(select, pageSize, pageNumber).execute();
    }

    // AssocOperator: AssocOperator000
	@Override
    public Boolean assocOperator000(DireccionC instance) throws SystemException {
        try {
            // EXIST (DepartamentoC)
            return assocOperator000Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: DireccionC, Assoc.Operator: AssocOperator000, Method: assocOperator000";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator000
	@Override
    public Boolean assocOperator000Range1 (DireccionC instance) throws SystemException {
        SQLExists sql = assocOperator000Range1Query(instance);
        return !new TypedQueryBuilder<DireccionC>(em, DireccionC.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator000
	@Override
    public SQLExists assocOperator000Range1Query (DireccionC instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(DireccionCConstants.CLASS_NAME, DireccionCConstants.ROLE_NAME_DEPARTAMENTOC, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: DireccionC, Assoc.Operator: AssocOperator000, Method: assocOperator000Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator001
	@Override
    public Boolean assocOperator001(DireccionC instance) throws SystemException {
        try {
            // EXIST (MunicipioC)
            return assocOperator001Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: DireccionC, Assoc.Operator: AssocOperator001, Method: assocOperator001";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator001
	@Override
    public Boolean assocOperator001Range1 (DireccionC instance) throws SystemException {
        SQLExists sql = assocOperator001Range1Query(instance);
        return !new TypedQueryBuilder<DireccionC>(em, DireccionC.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator001
	@Override
    public SQLExists assocOperator001Range1Query (DireccionC instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(DireccionCConstants.CLASS_NAME, DireccionCConstants.ROLE_NAME_MUNICIPIOC, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: DireccionC, Assoc.Operator: AssocOperator001, Method: assocOperator001Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator002
	@Override
    public Boolean assocOperator002(DireccionC instance) throws SystemException {
        try {
            // EXIST (DepartamentoC)
            return assocOperator002Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: DireccionC, Assoc.Operator: AssocOperator002, Method: assocOperator002";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator002
	@Override
    public Boolean assocOperator002Range1 (DireccionC instance) throws SystemException {
        SQLExists sql = assocOperator002Range1Query(instance);
        return !new TypedQueryBuilder<DireccionC>(em, DireccionC.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator002
	@Override
    public SQLExists assocOperator002Range1Query (DireccionC instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(DireccionCConstants.CLASS_NAME, DireccionCConstants.ROLE_NAME_DEPARTAMENTOC, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: DireccionC, Assoc.Operator: AssocOperator002, Method: assocOperator002Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator003
	@Override
    public Boolean assocOperator003(DireccionC instance) throws SystemException {
        try {
            // EXIST (DepartamentoC)
            return assocOperator003Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: DireccionC, Assoc.Operator: AssocOperator003, Method: assocOperator003";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator003
	@Override
    public Boolean assocOperator003Range1 (DireccionC instance) throws SystemException {
        SQLExists sql = assocOperator003Range1Query(instance);
        return !new TypedQueryBuilder<DireccionC>(em, DireccionC.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator003
	@Override
    public SQLExists assocOperator003Range1Query (DireccionC instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(DireccionCConstants.CLASS_NAME, DireccionCConstants.ROLE_NAME_DEPARTAMENTOC, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: DireccionC, Assoc.Operator: AssocOperator003, Method: assocOperator003Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator005
	@Override
    public Boolean assocOperator005(DireccionC instance) throws SystemException {
        try {
            // EXIST (MunicipioC)
            return assocOperator005Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: DireccionC, Assoc.Operator: AssocOperator005, Method: assocOperator005";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator005
	@Override
    public Boolean assocOperator005Range1 (DireccionC instance) throws SystemException {
        SQLExists sql = assocOperator005Range1Query(instance);
        return !new TypedQueryBuilder<DireccionC>(em, DireccionC.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator005
	@Override
    public SQLExists assocOperator005Range1Query (DireccionC instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(DireccionCConstants.CLASS_NAME, DireccionCConstants.ROLE_NAME_MUNICIPIOC, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: DireccionC, Assoc.Operator: AssocOperator005, Method: assocOperator005Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator006
	@Override
    public Boolean assocOperator006(DireccionC instance) throws SystemException {
        try {
            // EXIST (MunicipioC)
            return assocOperator006Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: DireccionC, Assoc.Operator: AssocOperator006, Method: assocOperator006";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator006
	@Override
    public Boolean assocOperator006Range1 (DireccionC instance) throws SystemException {
        SQLExists sql = assocOperator006Range1Query(instance);
        return !new TypedQueryBuilder<DireccionC>(em, DireccionC.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator006
	@Override
    public SQLExists assocOperator006Range1Query (DireccionC instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(DireccionCConstants.CLASS_NAME, DireccionCConstants.ROLE_NAME_MUNICIPIOC, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: DireccionC, Assoc.Operator: AssocOperator006, Method: assocOperator006Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator008
	@Override
    public Boolean assocOperator008(DireccionC instance) throws SystemException {
        try {
            // EXIST (PaisC)
            return assocOperator008Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: DireccionC, Assoc.Operator: AssocOperator008, Method: assocOperator008";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator008
	@Override
    public Boolean assocOperator008Range1 (DireccionC instance) throws SystemException {
        SQLExists sql = assocOperator008Range1Query(instance);
        return !new TypedQueryBuilder<DireccionC>(em, DireccionC.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator008
	@Override
    public SQLExists assocOperator008Range1Query (DireccionC instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(DireccionCConstants.CLASS_NAME, DireccionCConstants.ROLE_NAME_PAISC, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: DireccionC, Assoc.Operator: AssocOperator008, Method: assocOperator008Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator009
	@Override
    public Boolean assocOperator009(DireccionC instance) throws SystemException {
        try {
            // EXIST (PaisC)
            return assocOperator009Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: DireccionC, Assoc.Operator: AssocOperator009, Method: assocOperator009";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator009
	@Override
    public Boolean assocOperator009Range1 (DireccionC instance) throws SystemException {
        SQLExists sql = assocOperator009Range1Query(instance);
        return !new TypedQueryBuilder<DireccionC>(em, DireccionC.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator009
	@Override
    public SQLExists assocOperator009Range1Query (DireccionC instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(DireccionCConstants.CLASS_NAME, DireccionCConstants.ROLE_NAME_PAISC, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: DireccionC, Assoc.Operator: AssocOperator009, Method: assocOperator009Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator011
	@Override
    public Boolean assocOperator011(DireccionC instance) throws SystemException {
        try {
            // EXIST (TipoDireccionC)
            return assocOperator011Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: DireccionC, Assoc.Operator: AssocOperator011, Method: assocOperator011";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator011
	@Override
    public Boolean assocOperator011Range1 (DireccionC instance) throws SystemException {
        SQLExists sql = assocOperator011Range1Query(instance);
        return !new TypedQueryBuilder<DireccionC>(em, DireccionC.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator011
	@Override
    public SQLExists assocOperator011Range1Query (DireccionC instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(DireccionCConstants.CLASS_NAME, DireccionCConstants.ROLE_NAME_TIPODIRECCIONC, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: DireccionC, Assoc.Operator: AssocOperator011, Method: assocOperator011Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator012
	@Override
    public Boolean assocOperator012(DireccionC instance) throws SystemException {
        try {
            // EXIST (TipoDireccionC)
            return assocOperator012Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: DireccionC, Assoc.Operator: AssocOperator012, Method: assocOperator012";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator012
	@Override
    public Boolean assocOperator012Range1 (DireccionC instance) throws SystemException {
        SQLExists sql = assocOperator012Range1Query(instance);
        return !new TypedQueryBuilder<DireccionC>(em, DireccionC.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator012
	@Override
    public SQLExists assocOperator012Range1Query (DireccionC instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(DireccionCConstants.CLASS_NAME, DireccionCConstants.ROLE_NAME_TIPODIRECCIONC, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: DireccionC, Assoc.Operator: AssocOperator012, Method: assocOperator012Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator014
	@Override
    public Boolean assocOperator014(DireccionC instance) throws SystemException {
        try {
            // EXIST (DepartamentoC)
            return assocOperator014Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: DireccionC, Assoc.Operator: AssocOperator014, Method: assocOperator014";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator014
	@Override
    public Boolean assocOperator014Range1 (DireccionC instance) throws SystemException {
        SQLExists sql = assocOperator014Range1Query(instance);
        return !new TypedQueryBuilder<DireccionC>(em, DireccionC.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator014
	@Override
    public SQLExists assocOperator014Range1Query (DireccionC instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(DireccionCConstants.CLASS_NAME, DireccionCConstants.ROLE_NAME_DEPARTAMENTOC, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: DireccionC, Assoc.Operator: AssocOperator014, Method: assocOperator014Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator015
	@Override
    public Boolean assocOperator015(DireccionC instance) throws SystemException {
        try {
            // EXIST (MunicipioC)
            return assocOperator015Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: DireccionC, Assoc.Operator: AssocOperator015, Method: assocOperator015";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator015
	@Override
    public Boolean assocOperator015Range1 (DireccionC instance) throws SystemException {
        SQLExists sql = assocOperator015Range1Query(instance);
        return !new TypedQueryBuilder<DireccionC>(em, DireccionC.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator015
	@Override
    public SQLExists assocOperator015Range1Query (DireccionC instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(DireccionCConstants.CLASS_NAME, DireccionCConstants.ROLE_NAME_MUNICIPIOC, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: DireccionC, Assoc.Operator: AssocOperator015, Method: assocOperator015Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator016
	@Override
    public Boolean assocOperator016(DireccionC instance) throws SystemException {
        try {
            // EXIST (PaisC)
            return assocOperator016Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: DireccionC, Assoc.Operator: AssocOperator016, Method: assocOperator016";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator016
	@Override
    public Boolean assocOperator016Range1 (DireccionC instance) throws SystemException {
        SQLExists sql = assocOperator016Range1Query(instance);
        return !new TypedQueryBuilder<DireccionC>(em, DireccionC.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator016
	@Override
    public SQLExists assocOperator016Range1Query (DireccionC instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(DireccionCConstants.CLASS_NAME, DireccionCConstants.ROLE_NAME_PAISC, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: DireccionC, Assoc.Operator: AssocOperator016, Method: assocOperator016Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator017
	@Override
    public Boolean assocOperator017(DireccionC instance) throws SystemException {
        try {
            // EXIST (TipoDireccionC)
            return assocOperator017Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: DireccionC, Assoc.Operator: AssocOperator017, Method: assocOperator017";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator017
	@Override
    public Boolean assocOperator017Range1 (DireccionC instance) throws SystemException {
        SQLExists sql = assocOperator017Range1Query(instance);
        return !new TypedQueryBuilder<DireccionC>(em, DireccionC.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator017
	@Override
    public SQLExists assocOperator017Range1Query (DireccionC instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(DireccionCConstants.CLASS_NAME, DireccionCConstants.ROLE_NAME_TIPODIRECCIONC, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: DireccionC, Assoc.Operator: AssocOperator017, Method: assocOperator017Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator018
	@Override
    public Collection<TelefonoC> assocOperator018(DireccionC instance) throws SystemException {
        try {
            // FOR ALL TelefonosC DO TelefonosC.eliminar(TelefonosC)
        return assocOperator018Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: DireccionC, Assoc.Operator: AssocOperator018, Method: assocOperator018";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator018
	@Override
    public Collection<TelefonoC> assocOperator018Range1 (DireccionC instance) throws SystemException {

        SQLSelect sql = assocOperator018Range1Query(instance);
        return new TypedQueryBuilder<TelefonoC>(em, TelefonoC.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator018
	@Override
    public SQLPopulation assocOperator018Range1Query (DireccionC instance) throws SystemException {
        try {
            return new SQLPopulation(DireccionCConstants.CLASS_NAME, TelefonoCConstants.CLASS_NAME, instance.getOid(), DireccionCConstants.ROLE_NAME_TELEFONOSC);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: DireccionC, Assoc.Operator: AssocOperator018, Method: assocOperator018Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    @Override
    public void refreshEntity(Object object) {
        super.refreshEntity(object);
    }
}
