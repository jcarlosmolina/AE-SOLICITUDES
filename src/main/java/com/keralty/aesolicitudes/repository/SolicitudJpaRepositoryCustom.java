package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.exception.SystemException;
import com.keralty.aesolicitudes.persistence.BeneficiarioC;
import com.keralty.aesolicitudes.persistence.Direccion;
import com.keralty.aesolicitudes.persistence.DocumentoG;
import com.keralty.aesolicitudes.persistence.Persona;
import com.keralty.aesolicitudes.persistence.PersonaC;
import com.keralty.aesolicitudes.persistence.PlantillaEmail;
import com.keralty.aesolicitudes.persistence.ReportesDominio;
import com.keralty.aesolicitudes.persistence.Solicitud;
import com.keralty.aesolicitudes.persistence.TipoIdentificacion;
import com.keralty.aesolicitudes.persistence.Usuario;
import com.keralty.aesolicitudes.persistence.UsuarioReg;
import com.keralty.aesolicitudes.sqlutils.SQLCount;
import com.keralty.aesolicitudes.sqlutils.SQLExists;
import com.keralty.aesolicitudes.sqlutils.SQLForAllCondition;
import com.keralty.aesolicitudes.sqlutils.SQLGetOne;
import com.keralty.aesolicitudes.sqlutils.SQLParam;
import com.keralty.aesolicitudes.sqlutils.SQLPopulation;
import com.keralty.aesolicitudes.sqlutils.SQLSelect;
import com.keralty.aesolicitudes.sqlutils.SQLSum;
import java.util.Collection;
import java.util.List;

public interface SolicitudJpaRepositoryCustom {

    List<Solicitud> solveQuery(SQLSelect query);
    
    List<Solicitud> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    Boolean assocOperator000() throws SystemException;

    Boolean assocOperator000Range1() throws SystemException;
    
    SQLExists assocOperator000Range1Query(SQLSelect superQuery) throws SystemException;

    Long assocOperator001() throws SystemException;

    Long assocOperator001Range1() throws SystemException;
    
    SQLCount assocOperator001Range1Query(SQLSelect superQuery) throws SystemException;

    Boolean assocOperator002(Solicitud instance) throws SystemException;

    Boolean assocOperator002Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator002Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator003(Solicitud instance) throws SystemException;

    Boolean assocOperator003Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator003Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator004(Solicitud instance) throws SystemException;

    Boolean assocOperator004Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator004Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator005(Solicitud instance) throws SystemException;

    Boolean assocOperator005Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator005Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator006(Solicitud instance) throws SystemException;

    Boolean assocOperator006Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator006Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator007(Solicitud instance) throws SystemException;

    Boolean assocOperator007Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator007Range1Query(Solicitud instance) throws SystemException;

    Double assocOperator008(Solicitud instance) throws SystemException;

    Double assocOperator008Range1(Solicitud instance) throws SystemException;
    
    SQLSum assocOperator008Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator009(Solicitud instance) throws SystemException;

    Collection<Usuario> assocOperator009Range1(Solicitud instance) throws SystemException;
    
    SQLPopulation assocOperator009Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator010(Solicitud instance) throws SystemException;

    Boolean assocOperator010Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator010Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator011(Solicitud instance) throws SystemException;

    Boolean assocOperator011Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator011Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator012(Solicitud instance) throws SystemException;

    Boolean assocOperator012Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator012Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator013(Solicitud instance) throws SystemException;

    Boolean assocOperator013Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator013Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator014(Solicitud instance) throws SystemException;

    Collection<ReportesDominio> assocOperator014Range1(Solicitud instance) throws SystemException;
    
    SQLPopulation assocOperator014Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator015(Solicitud instance) throws SystemException;

    Boolean assocOperator015Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator015Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator016(Solicitud instance) throws SystemException;

    Collection<ReportesDominio> assocOperator016Range1(Solicitud instance) throws SystemException;
    
    SQLPopulation assocOperator016Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator017(Solicitud instance) throws SystemException;

    Boolean assocOperator017Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator017Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator018(Solicitud instance) throws SystemException;

    Collection<ReportesDominio> assocOperator018Range1(Solicitud instance) throws SystemException;
    
    SQLPopulation assocOperator018Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator019(Solicitud instance) throws SystemException;

    Boolean assocOperator019Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator019Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator020(Solicitud instance) throws SystemException;

    Collection<ReportesDominio> assocOperator020Range1(Solicitud instance) throws SystemException;
    
    SQLPopulation assocOperator020Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator021(Solicitud instance) throws SystemException;

    Boolean assocOperator021Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator021Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator022(Solicitud instance) throws SystemException;

    Collection<ReportesDominio> assocOperator022Range1(Solicitud instance) throws SystemException;
    
    SQLPopulation assocOperator022Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator023(Solicitud instance) throws SystemException;

    Boolean assocOperator023Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator023Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator024(Solicitud instance) throws SystemException;

    Collection<ReportesDominio> assocOperator024Range1(Solicitud instance) throws SystemException;
    
    SQLPopulation assocOperator024Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator025(Solicitud instance) throws SystemException;

    Boolean assocOperator025Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator025Range1Query(Solicitud instance) throws SystemException;

    Double assocOperator026(Solicitud instance) throws SystemException;

    Collection<Usuario> assocOperator026Range1(Solicitud instance) throws SystemException;
    
    SQLPopulation assocOperator026Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator027(Solicitud instance) throws SystemException;

    Collection<Usuario> assocOperator027Range1(Solicitud instance) throws SystemException;
    
    SQLPopulation assocOperator027Range1Query(Solicitud instance) throws SystemException;

    Long assocOperator028(Solicitud instance) throws SystemException;

    Collection<Usuario> assocOperator028Range1(Solicitud instance) throws SystemException;
    
    SQLPopulation assocOperator028Range1Query(Solicitud instance) throws SystemException;

    Long assocOperator029(Solicitud instance) throws SystemException;

    Long assocOperator029Range1(Solicitud instance) throws SystemException;
    
    SQLCount assocOperator029Range1Query(Solicitud instance) throws SystemException;

    Long assocOperator030(Solicitud instance) throws SystemException;

    Collection<ReportesDominio> assocOperator030Range1(Solicitud instance) throws SystemException;
    
    SQLPopulation assocOperator030Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator031(Solicitud instance) throws SystemException;

    Boolean assocOperator031Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator031Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator032(Solicitud instance) throws SystemException;

    Boolean assocOperator032Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator032Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator033(Solicitud instance) throws SystemException;

    Boolean assocOperator033Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator033Range1Query(Solicitud instance) throws SystemException;

    Long assocOperator034(Solicitud instance) throws SystemException;

    Collection<Usuario> assocOperator034Range1(Solicitud instance) throws SystemException;
    
    SQLPopulation assocOperator034Range1Query(Solicitud instance) throws SystemException;

    Long assocOperator035(Solicitud instance) throws SystemException;

    Collection<Usuario> assocOperator035Range1(Solicitud instance) throws SystemException;
    
    SQLPopulation assocOperator035Range1Query(Solicitud instance) throws SystemException;

    Long assocOperator036(Solicitud instance) throws SystemException;

    Long assocOperator036Range1(Solicitud instance) throws SystemException;
    
    SQLCount assocOperator036Range1Query(Solicitud instance) throws SystemException;

    Long assocOperator037(Solicitud instance) throws SystemException;

    Long assocOperator037Range1(Solicitud instance) throws SystemException;
    
    SQLCount assocOperator037Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator038(Solicitud instance) throws SystemException;

    Collection<ReportesDominio> assocOperator038Range1(Solicitud instance) throws SystemException;
    
    SQLPopulation assocOperator038Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator039(Solicitud instance) throws SystemException;

    Boolean assocOperator039Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator039Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator040(Solicitud instance) throws SystemException;

    Collection<ReportesDominio> assocOperator040Range1(Solicitud instance) throws SystemException;
    
    SQLPopulation assocOperator040Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator041(Solicitud instance) throws SystemException;

    Boolean assocOperator041Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator041Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator042(Solicitud instance) throws SystemException;

    Boolean assocOperator042Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator042Range1Query(Solicitud instance) throws SystemException;

    Long assocOperator043(Solicitud instance) throws SystemException;

    Long assocOperator043Range1(Solicitud instance) throws SystemException;
    
    SQLCount assocOperator043Range1Query(Solicitud instance) throws SystemException;

    Long assocOperator044(Solicitud instance) throws SystemException;

    Long assocOperator044Range1(Solicitud instance) throws SystemException;
    
    SQLCount assocOperator044Range1Query(Solicitud instance) throws SystemException;

    Long assocOperator045(Solicitud instance) throws SystemException;

    Collection<UsuarioReg> assocOperator045Range1(Solicitud instance) throws SystemException;
    
    SQLPopulation assocOperator045Range1Query(Solicitud instance) throws SystemException;

    Long assocOperator046(Solicitud instance) throws SystemException;

    Collection<Usuario> assocOperator046Range1(Solicitud instance) throws SystemException;
    
    SQLPopulation assocOperator046Range1Query(Solicitud instance) throws SystemException;

    Long assocOperator047(Solicitud instance) throws SystemException;

    Long assocOperator047Range1(Solicitud instance) throws SystemException;
    
    SQLCount assocOperator047Range1Query(Solicitud instance) throws SystemException;

    String assocOperator048(Solicitud instance) throws SystemException;

    String assocOperator048Range1(Solicitud instance) throws SystemException;
    
    SQLGetOne assocOperator048Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator049(Solicitud instance) throws SystemException;

    Collection<Usuario> assocOperator049Range1(Solicitud instance) throws SystemException;
    
    SQLPopulation assocOperator049Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator050(Solicitud instance) throws SystemException;

    Collection<Usuario> assocOperator050Range1(Solicitud instance) throws SystemException;
    
    SQLPopulation assocOperator050Range1Query(Solicitud instance) throws SystemException;

    Long assocOperator051(Solicitud instance) throws SystemException;

    Long assocOperator051Range1(Solicitud instance) throws SystemException;
    
    SQLCount assocOperator051Range1Query(Solicitud instance) throws SystemException;

    Long assocOperator052(Solicitud instance) throws SystemException;

    Long assocOperator052Range1(Solicitud instance) throws SystemException;
    
    SQLCount assocOperator052Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator053(Solicitud instance) throws SystemException;

    Collection<ReportesDominio> assocOperator053Range1(Solicitud instance) throws SystemException;
    
    SQLPopulation assocOperator053Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator054(Solicitud instance) throws SystemException;

    Boolean assocOperator054Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator054Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator055(Solicitud instance) throws SystemException;

    Boolean assocOperator055Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator055Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator056(Solicitud instance) throws SystemException;

    Collection<Usuario> assocOperator056Range1(Solicitud instance) throws SystemException;
    
    SQLPopulation assocOperator056Range1Query(Solicitud instance) throws SystemException;

    Double assocOperator057(Solicitud instance) throws SystemException;

    Collection<Usuario> assocOperator057Range1(Solicitud instance) throws SystemException;
    
    SQLPopulation assocOperator057Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator058(Solicitud instance) throws SystemException;

    Collection<ReportesDominio> assocOperator058Range1(Solicitud instance) throws SystemException;
    
    SQLPopulation assocOperator058Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator059(Solicitud instance) throws SystemException;

    Boolean assocOperator059Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator059Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator060(Solicitud instance) throws SystemException;

    Boolean assocOperator060Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator060Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator061(Solicitud instance) throws SystemException;

    Boolean assocOperator061Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator061Range1Query(Solicitud instance) throws SystemException;

    Long assocOperator062(Solicitud instance) throws SystemException;

    Long assocOperator062Range1(Solicitud instance) throws SystemException;
    
    SQLCount assocOperator062Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator063(Solicitud instance) throws SystemException;

    Boolean assocOperator063Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator063Range1Query(Solicitud instance) throws SystemException;

    Long assocOperator064(Solicitud instance) throws SystemException;

    Collection<Usuario> assocOperator064Range1(Solicitud instance) throws SystemException;
    
    SQLPopulation assocOperator064Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator065(Solicitud instance) throws SystemException;

    Boolean assocOperator065Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator065Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator066(Solicitud instance) throws SystemException;

    Boolean assocOperator066Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator066Range1Query(Solicitud instance) throws SystemException;

    Long assocOperator067(Solicitud instance) throws SystemException;

    Long assocOperator067Range1(Solicitud instance) throws SystemException;
    
    SQLCount assocOperator067Range1Query(Solicitud instance) throws SystemException;

    String assocOperator068(Solicitud instance) throws SystemException;

    String assocOperator068Range1(Solicitud instance) throws SystemException;
    
    SQLGetOne assocOperator068Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator069(Solicitud instance) throws SystemException;

    Boolean assocOperator069Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator069Range1Query(Solicitud instance, SQLSelect superQuery) throws SystemException;

    Boolean assocOperator070(Solicitud instance) throws SystemException;

    Boolean assocOperator070Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator070Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator071() throws SystemException;

    Boolean assocOperator071Range1() throws SystemException;
    
    SQLExists assocOperator071Range1Query(SQLSelect superQuery) throws SystemException;

    Long assocOperator072() throws SystemException;

    Long assocOperator072Range1() throws SystemException;
    
    SQLCount assocOperator072Range1Query(SQLSelect superQuery) throws SystemException;

    Long assocOperator073() throws SystemException;

    Long assocOperator073Range1() throws SystemException;
    
    SQLCount assocOperator073Range1Query(SQLSelect superQuery) throws SystemException;

    Boolean assocOperator074(TipoIdentificacion vTipoDoc, String vNumDoc) throws SystemException;

    Boolean assocOperator074Range1(TipoIdentificacion vTipoDoc, String vNumDoc) throws SystemException;
    
    SQLExists assocOperator074Range1Query(TipoIdentificacion vTipoDoc, String vNumDoc, SQLSelect superQuery) throws SystemException;

    Boolean assocOperator075(Persona voPersona) throws SystemException;

    Boolean assocOperator075Range1(Persona voPersona) throws SystemException;
    
    SQLExists assocOperator075Range1Query(Persona voPersona, SQLSelect superQuery) throws SystemException;

    Boolean assocOperator076() throws SystemException;

    Boolean assocOperator076Range1() throws SystemException;
    
    SQLExists assocOperator076Range1Query(SQLSelect superQuery) throws SystemException;

    Long assocOperator077() throws SystemException;

    Long assocOperator077Range1() throws SystemException;
    
    SQLCount assocOperator077Range1Query(SQLSelect superQuery) throws SystemException;

    Long assocOperator078() throws SystemException;

    Long assocOperator078Range1() throws SystemException;
    
    SQLCount assocOperator078Range1Query(SQLSelect superQuery) throws SystemException;

    Boolean assocOperator079(TipoIdentificacion voTipoDoc, String vNumDoc) throws SystemException;

    Boolean assocOperator079Range1(TipoIdentificacion voTipoDoc, String vNumDoc) throws SystemException;
    
    SQLExists assocOperator079Range1Query(TipoIdentificacion voTipoDoc, String vNumDoc, SQLSelect superQuery) throws SystemException;

    Boolean assocOperator080(TipoIdentificacion voTipoDoc, String vNumDoc) throws SystemException;

    Boolean assocOperator080Range1(TipoIdentificacion voTipoDoc, String vNumDoc) throws SystemException;
    
    SQLExists assocOperator080Range1Query(TipoIdentificacion voTipoDoc, String vNumDoc, SQLSelect superQuery) throws SystemException;

    Boolean assocOperator081(TipoIdentificacion voTipoDoc, String vNumDoc) throws SystemException;

    Boolean assocOperator081Range1(TipoIdentificacion voTipoDoc, String vNumDoc) throws SystemException;
    
    SQLExists assocOperator081Range1Query(TipoIdentificacion voTipoDoc, String vNumDoc, SQLSelect superQuery) throws SystemException;

    Boolean assocOperator082(TipoIdentificacion vTipoDoc, String vNumDoc) throws SystemException;

    Boolean assocOperator082Range1(TipoIdentificacion vTipoDoc, String vNumDoc) throws SystemException;
    
    SQLExists assocOperator082Range1Query(TipoIdentificacion vTipoDoc, String vNumDoc, SQLSelect superQuery) throws SystemException;

    Boolean assocOperator083(TipoIdentificacion vTipoDoc, String vNumDoc) throws SystemException;

    Boolean assocOperator083Range1(TipoIdentificacion vTipoDoc, String vNumDoc) throws SystemException;
    
    SQLExists assocOperator083Range1Query(TipoIdentificacion vTipoDoc, String vNumDoc, SQLSelect superQuery) throws SystemException;

    Boolean assocOperator084(TipoIdentificacion vTipoDoc, String vNumDoc) throws SystemException;

    Boolean assocOperator084Range1(TipoIdentificacion vTipoDoc, String vNumDoc) throws SystemException;
    
    SQLExists assocOperator084Range1Query(TipoIdentificacion vTipoDoc, String vNumDoc, SQLSelect superQuery) throws SystemException;

    Boolean assocOperator085(TipoIdentificacion vTipoDoc, String vNumDoc) throws SystemException;

    Boolean assocOperator085Range1(TipoIdentificacion vTipoDoc, String vNumDoc) throws SystemException;
    
    SQLExists assocOperator085Range1Query(TipoIdentificacion vTipoDoc, String vNumDoc, SQLSelect superQuery) throws SystemException;

    Boolean assocOperator086(TipoIdentificacion vTipoDoc, String vNumDoc) throws SystemException;

    Boolean assocOperator086Range1(TipoIdentificacion vTipoDoc, String vNumDoc) throws SystemException;
    
    SQLExists assocOperator086Range1Query(TipoIdentificacion vTipoDoc, String vNumDoc, SQLSelect superQuery) throws SystemException;

    Boolean assocOperator087(TipoIdentificacion vTipoDoc, String vNumDoc) throws SystemException;

    Boolean assocOperator087Range1(TipoIdentificacion vTipoDoc, String vNumDoc) throws SystemException;
    
    SQLExists assocOperator087Range1Query(TipoIdentificacion vTipoDoc, String vNumDoc, SQLSelect superQuery) throws SystemException;

    Boolean assocOperator088(TipoIdentificacion vTipoDoc, String vNumDoc) throws SystemException;

    Boolean assocOperator088Range1(TipoIdentificacion vTipoDoc, String vNumDoc) throws SystemException;
    
    SQLExists assocOperator088Range1Query(TipoIdentificacion vTipoDoc, String vNumDoc, SQLSelect superQuery) throws SystemException;

    Boolean assocOperator089(Solicitud instance) throws SystemException;

    Collection<Usuario> assocOperator089Range1(Solicitud instance) throws SystemException;
    
    SQLPopulation assocOperator089Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator090(Solicitud instance) throws SystemException;

    Collection<Usuario> assocOperator090Range1(Solicitud instance) throws SystemException;
    
    SQLPopulation assocOperator090Range1Query(Solicitud instance) throws SystemException;

    Long assocOperator091(Solicitud instance) throws SystemException;

    Long assocOperator091Range1(Solicitud instance) throws SystemException;
    
    SQLCount assocOperator091Range1Query(Solicitud instance) throws SystemException;

    Long assocOperator092(Solicitud instance) throws SystemException;

    Long assocOperator092Range1(Solicitud instance) throws SystemException;
    
    SQLCount assocOperator092Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator093(Solicitud instance) throws SystemException;

    Boolean assocOperator093Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator093Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator094(Solicitud instance) throws SystemException;

    Boolean assocOperator094Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator094Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator095(Solicitud instance) throws SystemException;

    Boolean assocOperator095Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator095Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator096(Solicitud instance) throws SystemException;

    Boolean assocOperator096Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator096Range1Query(Solicitud instance) throws SystemException;

    Long assocOperator097(Solicitud instance) throws SystemException;

    Long assocOperator097Range1(Solicitud instance) throws SystemException;
    
    SQLCount assocOperator097Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator098(Solicitud instance) throws SystemException;

    Boolean assocOperator098Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator098Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator099(Solicitud instance) throws SystemException;

    Boolean assocOperator099Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator099Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator100(Solicitud instance) throws SystemException;

    Boolean assocOperator100Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator100Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator101(Solicitud instance) throws SystemException;

    Boolean assocOperator101Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator101Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator102(Solicitud instance) throws SystemException;

    Boolean assocOperator102Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator102Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator103(Solicitud instance) throws SystemException;

    Boolean assocOperator103Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator103Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator104(Solicitud instance) throws SystemException;

    Boolean assocOperator104Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator104Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator105(Solicitud instance) throws SystemException;

    Boolean assocOperator105Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator105Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator106(Solicitud instance) throws SystemException;

    Boolean assocOperator106Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator106Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator107(Solicitud instance) throws SystemException;

    Boolean assocOperator107Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator107Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator108(Solicitud instance) throws SystemException;

    Boolean assocOperator108Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator108Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator109(Solicitud instance) throws SystemException;

    Boolean assocOperator109Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator109Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator110(Solicitud instance) throws SystemException;

    Boolean assocOperator110Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator110Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator111(Solicitud instance) throws SystemException;

    Boolean assocOperator111Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator111Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator112(Solicitud instance) throws SystemException;

    Boolean assocOperator112Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator112Range1Query(Solicitud instance) throws SystemException;

    Long assocOperator113(Solicitud instance) throws SystemException;

    Long assocOperator113Range1(Solicitud instance) throws SystemException;
    
    SQLCount assocOperator113Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator114(Solicitud instance) throws SystemException;

    Collection<Usuario> assocOperator114Range1(Solicitud instance) throws SystemException;
    
    SQLPopulation assocOperator114Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator115(Solicitud instance) throws SystemException;

    Boolean assocOperator115Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator115Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator116(Solicitud instance) throws SystemException;

    Boolean assocOperator116Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator116Range1Query(Solicitud instance) throws SystemException;

    Long assocOperator117(Solicitud instance) throws SystemException;

    Collection<Usuario> assocOperator117Range1(Solicitud instance) throws SystemException;
    
    SQLPopulation assocOperator117Range1Query(Solicitud instance) throws SystemException;

    Long assocOperator118(Solicitud instance) throws SystemException;

    Long assocOperator118Range1(Solicitud instance) throws SystemException;
    
    SQLCount assocOperator118Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator119(Solicitud instance) throws SystemException;

    Boolean assocOperator119Range1(Solicitud instance) throws SystemException;
    
    SQLForAllCondition assocOperator119Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator120(Solicitud instance) throws SystemException;

    Boolean assocOperator120Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator120Range1Query(Solicitud instance, SQLSelect superQuery) throws SystemException;

    Boolean assocOperator121(Solicitud instance, Solicitud solicitudvalidarAtributosUsuariopthisSolicitud) throws SystemException;

    Collection<Usuario> assocOperator121Range1(Solicitud instance, Solicitud solicitudvalidarAtributosUsuariopthisSolicitud) throws SystemException;
    
    SQLPopulation assocOperator121Range1Query(Solicitud instance, Solicitud solicitudvalidarAtributosUsuariopthisSolicitud) throws SystemException;

    Boolean assocOperator122(Solicitud instance) throws SystemException;

    Boolean assocOperator122Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator122Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator123(Solicitud instance) throws SystemException;

    Collection<Usuario> assocOperator123Range1(Solicitud instance) throws SystemException;
    
    SQLPopulation assocOperator123Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator124(Solicitud instance) throws SystemException;

    Boolean assocOperator124Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator124Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator125(Solicitud instance) throws SystemException;

    Collection<Usuario> assocOperator125Range1(Solicitud instance) throws SystemException;
    
    SQLPopulation assocOperator125Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator126(Solicitud instance) throws SystemException;

    Boolean assocOperator126Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator126Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator127(Solicitud instance) throws SystemException;

    Boolean assocOperator127Range1(Solicitud instance) throws SystemException;
    
    SQLForAllCondition assocOperator127Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator128(Solicitud instance) throws SystemException;

    Boolean assocOperator128Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator128Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator129(Solicitud instance) throws SystemException;

    Collection<Usuario> assocOperator129Range1(Solicitud instance) throws SystemException;
    
    SQLPopulation assocOperator129Range1Query(Solicitud instance) throws SystemException;

    Long assocOperator130(Solicitud instance) throws SystemException;

    Collection<Usuario> assocOperator130Range1(Solicitud instance) throws SystemException;
    
    SQLPopulation assocOperator130Range1Query(Solicitud instance) throws SystemException;

    Long assocOperator131(Solicitud instance) throws SystemException;

    Long assocOperator131Range1(Solicitud instance) throws SystemException;
    
    SQLCount assocOperator131Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator132(Solicitud instance) throws SystemException;

    Boolean assocOperator132Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator132Range1Query(Solicitud instance) throws SystemException;

    Long assocOperator133(Solicitud instance) throws SystemException;

    Long assocOperator133Range1(Solicitud instance) throws SystemException;
    
    SQLCount assocOperator133Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator134(Solicitud instance) throws SystemException;

    Boolean assocOperator134Range1(Solicitud instance) throws SystemException;
    
    SQLForAllCondition assocOperator134Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator135(Solicitud instance) throws SystemException;

    Boolean assocOperator135Range1(Solicitud instance) throws SystemException;
    
    SQLForAllCondition assocOperator135Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator136(Solicitud instance) throws SystemException;

    Boolean assocOperator136Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator136Range1Query(Solicitud instance, SQLSelect superQuery) throws SystemException;

    Boolean assocOperator137(Solicitud instance) throws SystemException;

    Boolean assocOperator137Range1(Solicitud instance) throws SystemException;
    
    SQLForAllCondition assocOperator137Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator138(Solicitud instance) throws SystemException;

    Boolean assocOperator138Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator138Range1Query(Solicitud instance, SQLSelect superQuery) throws SystemException;

    Boolean assocOperator139(Solicitud instance) throws SystemException;

    Collection<Usuario> assocOperator139Range1(Solicitud instance) throws SystemException;
    
    SQLPopulation assocOperator139Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator140(Solicitud instance) throws SystemException;

    Collection<Usuario> assocOperator140Range1(Solicitud instance) throws SystemException;
    
    SQLPopulation assocOperator140Range1Query(Solicitud instance) throws SystemException;

    Long assocOperator141(Solicitud instance, Solicitud solicitudvalidarAtributosUsuariopthisSolicitud) throws SystemException;

    Collection<Usuario> assocOperator141Range1(Solicitud instance, Solicitud solicitudvalidarAtributosUsuariopthisSolicitud) throws SystemException;
    
    SQLPopulation assocOperator141Range1Query(Solicitud instance, Solicitud solicitudvalidarAtributosUsuariopthisSolicitud) throws SystemException;

    Boolean assocOperator142(Solicitud instance) throws SystemException;

    Boolean assocOperator142Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator142Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator143(Solicitud instance) throws SystemException;

    Boolean assocOperator143Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator143Range1Query(Solicitud instance) throws SystemException;

    Long assocOperator144(Solicitud instance) throws SystemException;

    Long assocOperator144Range1(Solicitud instance) throws SystemException;
    
    SQLCount assocOperator144Range1Query(Solicitud instance) throws SystemException;

    Long assocOperator145(Solicitud instance) throws SystemException;

    Long assocOperator145Range1(Solicitud instance) throws SystemException;
    
    SQLCount assocOperator145Range1Query(Solicitud instance) throws SystemException;

    Long assocOperator146(Solicitud instance) throws SystemException;

    Long assocOperator146Range1(Solicitud instance) throws SystemException;
    
    SQLCount assocOperator146Range1Query(Solicitud instance) throws SystemException;

    Long assocOperator147(Solicitud instance) throws SystemException;

    Long assocOperator147Range1(Solicitud instance) throws SystemException;
    
    SQLCount assocOperator147Range1Query(Solicitud instance) throws SystemException;

    Long assocOperator148(Solicitud instance) throws SystemException;

    Long assocOperator148Range1(Solicitud instance) throws SystemException;
    
    SQLCount assocOperator148Range1Query(Solicitud instance) throws SystemException;

    Long assocOperator149(Solicitud instance, Long solicitudTGETPLANTILLAREPORTEptTipo) throws SystemException;

    Collection<ReportesDominio> assocOperator149Range1(Solicitud instance, Long solicitudTGETPLANTILLAREPORTEptTipo) throws SystemException;
    
    SQLPopulation assocOperator149Range1Query(Solicitud instance, Long solicitudTGETPLANTILLAREPORTEptTipo) throws SystemException;

    Long assocOperator150(Solicitud instance) throws SystemException;

    Long assocOperator150Range1(Solicitud instance) throws SystemException;
    
    SQLCount assocOperator150Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator151(Solicitud instance) throws SystemException;

    Boolean assocOperator151Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator151Range1Query(Solicitud instance) throws SystemException;

    Long assocOperator152(Solicitud instance) throws SystemException;

    Long assocOperator152Range1(Solicitud instance) throws SystemException;
    
    SQLCount assocOperator152Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator154(Solicitud instance) throws SystemException;

    Boolean assocOperator154Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator154Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator156(Solicitud instance) throws SystemException;

    Boolean assocOperator156Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator156Range1Query(Solicitud instance) throws SystemException;

    Collection<Direccion> assocOperator158(Persona solicitudTCREAROMODCONTRATANTEptPersonaContratante) throws SystemException;

    Collection<Direccion> assocOperator158Range1(Persona solicitudTCREAROMODCONTRATANTEptPersonaContratante) throws SystemException;
    
    SQLPopulation assocOperator158Range1Query(Persona solicitudTCREAROMODCONTRATANTEptPersonaContratante) throws SystemException;

    Collection<Direccion> assocOperator159(Persona solicitudTCREAROMODCONTRATANTEptPersonaContratante) throws SystemException;

    Collection<Direccion> assocOperator159Range1(Persona solicitudTCREAROMODCONTRATANTEptPersonaContratante) throws SystemException;
    
    SQLPopulation assocOperator159Range1Query(Persona solicitudTCREAROMODCONTRATANTEptPersonaContratante) throws SystemException;

    Boolean assocOperator160(Solicitud instance) throws SystemException;

    Boolean assocOperator160Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator160Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator161(Solicitud instance) throws SystemException;

    Boolean assocOperator161Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator161Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator163(Solicitud instance) throws SystemException;

    Boolean assocOperator163Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator163Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator165(Solicitud instance) throws SystemException;

    Boolean assocOperator165Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator165Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator166(Solicitud instance) throws SystemException;

    Boolean assocOperator166Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator166Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator168(Solicitud instance) throws SystemException;

    Boolean assocOperator168Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator168Range1Query(Solicitud instance) throws SystemException;

    Collection<Direccion> assocOperator170(Solicitud instance) throws SystemException;

    Collection<Direccion> assocOperator170Range1(Solicitud instance) throws SystemException;
    
    SQLPopulation assocOperator170Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator171(Solicitud instance) throws SystemException;

    Boolean assocOperator171Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator171Range1Query(Solicitud instance) throws SystemException;

    Collection<BeneficiarioC> assocOperator175(Solicitud instance) throws SystemException;

    Collection<BeneficiarioC> assocOperator175Range1(Solicitud instance) throws SystemException;
    
    SQLPopulation assocOperator175Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator176(Solicitud instance) throws SystemException;

    Boolean assocOperator176Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator176Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator177(Solicitud instance) throws SystemException;

    Collection<PersonaC> assocOperator177Range1(Solicitud instance) throws SystemException;
    
    SQLPopulation assocOperator177Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator178(Solicitud instance) throws SystemException;

    Boolean assocOperator178Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator178Range1Query(Solicitud instance) throws SystemException;

    Collection<BeneficiarioC> assocOperator180(Solicitud instance, BeneficiarioC solicitudTUPDATEBENEFICIARIOpBeneficiarioC) throws SystemException;

    Collection<BeneficiarioC> assocOperator180Range1(Solicitud instance, BeneficiarioC solicitudTUPDATEBENEFICIARIOpBeneficiarioC) throws SystemException;
    
    SQLPopulation assocOperator180Range1Query(Solicitud instance, BeneficiarioC solicitudTUPDATEBENEFICIARIOpBeneficiarioC) throws SystemException;

    Collection<Usuario> assocOperator181(Solicitud instance, BeneficiarioC solicitudTUPDATEBENEFICIARIOpBeneficiarioC) throws SystemException;

    Collection<Usuario> assocOperator181Range1(Solicitud instance, BeneficiarioC solicitudTUPDATEBENEFICIARIOpBeneficiarioC) throws SystemException;
    
    SQLPopulation assocOperator181Range1Query(Solicitud instance, BeneficiarioC solicitudTUPDATEBENEFICIARIOpBeneficiarioC) throws SystemException;

    Boolean assocOperator182(BeneficiarioC solicitudTUPDATEBENEFICIARIOpBeneficiarioC) throws SystemException;

    Boolean assocOperator182Range1(BeneficiarioC solicitudTUPDATEBENEFICIARIOpBeneficiarioC) throws SystemException;
    
    SQLExists assocOperator182Range1Query(BeneficiarioC solicitudTUPDATEBENEFICIARIOpBeneficiarioC, SQLSelect superQuery) throws SystemException;

    Collection<BeneficiarioC> assocOperator185(Solicitud instance) throws SystemException;

    Collection<BeneficiarioC> assocOperator185Range1(Solicitud instance) throws SystemException;
    
    SQLPopulation assocOperator185Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator186(Solicitud instance) throws SystemException;

    Boolean assocOperator186Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator186Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator187(Solicitud instance) throws SystemException;

    Boolean assocOperator187Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator187Range1Query(Solicitud instance) throws SystemException;

    Collection<Usuario> assocOperator188(Solicitud instance, String solicitudTCREARDOCNUMIDSIEXISTEpNumIdentificacion) throws SystemException;

    Collection<Usuario> assocOperator188Range1(Solicitud instance, String solicitudTCREARDOCNUMIDSIEXISTEpNumIdentificacion) throws SystemException;
    
    SQLPopulation assocOperator188Range1Query(Solicitud instance, String solicitudTCREARDOCNUMIDSIEXISTEpNumIdentificacion) throws SystemException;

    Boolean assocOperator190(Solicitud instance) throws SystemException;

    Boolean assocOperator190Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator190Range1Query(Solicitud instance) throws SystemException;

    Collection<Usuario> assocOperator193(Solicitud instance) throws SystemException;

    Collection<Usuario> assocOperator193Range1(Solicitud instance) throws SystemException;
    
    SQLPopulation assocOperator193Range1Query(Solicitud instance) throws SystemException;

    Collection<Usuario> assocOperator194(Solicitud instance) throws SystemException;

    Collection<Usuario> assocOperator194Range1(Solicitud instance) throws SystemException;
    
    SQLPopulation assocOperator194Range1Query(Solicitud instance) throws SystemException;

    Collection<Usuario> assocOperator196(Solicitud instance) throws SystemException;

    Collection<Usuario> assocOperator196Range1(Solicitud instance) throws SystemException;
    
    SQLPopulation assocOperator196Range1Query(Solicitud instance) throws SystemException;

    Collection<Usuario> assocOperator197(Solicitud instance) throws SystemException;

    Collection<Usuario> assocOperator197Range1(Solicitud instance) throws SystemException;
    
    SQLPopulation assocOperator197Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator199(Solicitud instance) throws SystemException;

    Boolean assocOperator199Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator199Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator200(Solicitud instance) throws SystemException;

    Boolean assocOperator200Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator200Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator201(Solicitud instance) throws SystemException;

    Boolean assocOperator201Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator201Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator202(Solicitud instance) throws SystemException;

    Boolean assocOperator202Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator202Range1Query(Solicitud instance) throws SystemException;

    Collection<Usuario> assocOperator205(Solicitud instance) throws SystemException;

    Collection<Usuario> assocOperator205Range1(Solicitud instance) throws SystemException;
    
    SQLPopulation assocOperator205Range1Query(Solicitud instance) throws SystemException;

    Collection<Usuario> assocOperator206(Solicitud instance) throws SystemException;

    Collection<Usuario> assocOperator206Range1(Solicitud instance) throws SystemException;
    
    SQLPopulation assocOperator206Range1Query(Solicitud instance) throws SystemException;

    Collection<Usuario> assocOperator208(Solicitud instance) throws SystemException;

    Collection<Usuario> assocOperator208Range1(Solicitud instance) throws SystemException;
    
    SQLPopulation assocOperator208Range1Query(Solicitud instance) throws SystemException;

    Collection<Usuario> assocOperator210(Solicitud instance) throws SystemException;

    Collection<Usuario> assocOperator210Range1(Solicitud instance) throws SystemException;
    
    SQLPopulation assocOperator210Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator211(Solicitud instance) throws SystemException;

    Boolean assocOperator211Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator211Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator212(Solicitud instance, TipoIdentificacion solicitudTINDICARTITULAR2AUXptpagrTipoIdentificacion, String solicitudTINDICARTITULAR2AUXptpatrNumIdentificacion) throws SystemException;

    Boolean assocOperator212Range1(Solicitud instance, TipoIdentificacion solicitudTINDICARTITULAR2AUXptpagrTipoIdentificacion, String solicitudTINDICARTITULAR2AUXptpatrNumIdentificacion) throws SystemException;
    
    SQLExists assocOperator212Range1Query(Solicitud instance, TipoIdentificacion solicitudTINDICARTITULAR2AUXptpagrTipoIdentificacion, String solicitudTINDICARTITULAR2AUXptpatrNumIdentificacion) throws SystemException;

    Boolean assocOperator213(Solicitud instance) throws SystemException;

    Boolean assocOperator213Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator213Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator214(Solicitud instance, TipoIdentificacion solicitudTINDICARTITULAR2AUXptpagrTipoIdentificacion, String solicitudTINDICARTITULAR2AUXptpatrNumIdentificacion) throws SystemException;

    Boolean assocOperator214Range1(Solicitud instance, TipoIdentificacion solicitudTINDICARTITULAR2AUXptpagrTipoIdentificacion, String solicitudTINDICARTITULAR2AUXptpatrNumIdentificacion) throws SystemException;
    
    SQLExists assocOperator214Range1Query(Solicitud instance, TipoIdentificacion solicitudTINDICARTITULAR2AUXptpagrTipoIdentificacion, String solicitudTINDICARTITULAR2AUXptpatrNumIdentificacion) throws SystemException;

    Boolean assocOperator216(Solicitud instance) throws SystemException;

    Boolean assocOperator216Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator216Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator218(Solicitud instance) throws SystemException;

    Boolean assocOperator218Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator218Range1Query(Solicitud instance) throws SystemException;

    Collection<Usuario> assocOperator219(Solicitud instance) throws SystemException;

    Collection<Usuario> assocOperator219Range1(Solicitud instance) throws SystemException;
    
    SQLPopulation assocOperator219Range1Query(Solicitud instance) throws SystemException;

    Collection<Usuario> assocOperator222(Solicitud instance) throws SystemException;

    Collection<Usuario> assocOperator222Range1(Solicitud instance) throws SystemException;
    
    SQLPopulation assocOperator222Range1Query(Solicitud instance) throws SystemException;

    Collection<DocumentoG> assocOperator223(Solicitud instance) throws SystemException;

    Collection<DocumentoG> assocOperator223Range1(Solicitud instance) throws SystemException;
    
    SQLPopulation assocOperator223Range1Query(Solicitud instance) throws SystemException;

    Long assocOperator224(Solicitud instance) throws SystemException;

    Long assocOperator224Range1(Solicitud instance) throws SystemException;
    
    SQLSum assocOperator224Range1Query(Solicitud instance) throws SystemException;

    Long assocOperator225(Solicitud instance) throws SystemException;

    Long assocOperator225Range1(Solicitud instance) throws SystemException;
    
    SQLSum assocOperator225Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator228(Solicitud instance) throws SystemException;

    Boolean assocOperator228Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator228Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator229(Solicitud instance) throws SystemException;

    Boolean assocOperator229Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator229Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator234(Solicitud instance) throws SystemException;

    Boolean assocOperator234Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator234Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator235(Solicitud instance) throws SystemException;

    Boolean assocOperator235Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator235Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator236(Solicitud instance) throws SystemException;

    Boolean assocOperator236Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator236Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator237(Solicitud instance) throws SystemException;

    Boolean assocOperator237Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator237Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator239(Solicitud instance) throws SystemException;

    Boolean assocOperator239Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator239Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator241(Solicitud instance) throws SystemException;

    Boolean assocOperator241Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator241Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator243(Solicitud instance) throws SystemException;

    Boolean assocOperator243Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator243Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator245(Solicitud instance) throws SystemException;

    Boolean assocOperator245Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator245Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator249(Solicitud instance) throws SystemException;

    Boolean assocOperator249Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator249Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator250(Solicitud instance) throws SystemException;

    Boolean assocOperator250Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator250Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator251(Solicitud instance) throws SystemException;

    Boolean assocOperator251Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator251Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator253(Solicitud instance) throws SystemException;

    Boolean assocOperator253Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator253Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator254(Solicitud instance) throws SystemException;

    Boolean assocOperator254Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator254Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator255(Solicitud instance) throws SystemException;

    Boolean assocOperator255Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator255Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator257(Solicitud instance) throws SystemException;

    Boolean assocOperator257Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator257Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator260(Solicitud instance) throws SystemException;

    Boolean assocOperator260Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator260Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator261(Solicitud instance) throws SystemException;

    Boolean assocOperator261Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator261Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator264(Solicitud instance) throws SystemException;

    Boolean assocOperator264Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator264Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator265(Solicitud instance) throws SystemException;

    Boolean assocOperator265Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator265Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator268(Solicitud instance) throws SystemException;

    Boolean assocOperator268Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator268Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator269(Solicitud instance) throws SystemException;

    Boolean assocOperator269Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator269Range1Query(Solicitud instance) throws SystemException;

    Long assocOperator273(Solicitud instance) throws SystemException;

    Long assocOperator273Range1(Solicitud instance) throws SystemException;
    
    SQLCount assocOperator273Range1Query(Solicitud instance) throws SystemException;

    Long assocOperator274(Solicitud instance) throws SystemException;

    Long assocOperator274Range1(Solicitud instance) throws SystemException;
    
    SQLCount assocOperator274Range1Query(Solicitud instance) throws SystemException;

    Long assocOperator275(Solicitud instance) throws SystemException;

    Long assocOperator275Range1(Solicitud instance) throws SystemException;
    
    SQLCount assocOperator275Range1Query(Solicitud instance) throws SystemException;

    Collection<DocumentoG> assocOperator276(Solicitud instance) throws SystemException;

    Collection<DocumentoG> assocOperator276Range1(Solicitud instance) throws SystemException;
    
    SQLPopulation assocOperator276Range1Query(Solicitud instance) throws SystemException;

    Collection<DocumentoG> assocOperator278(Solicitud instance, Persona solicitudTSUBIRDOCUMENTOATOptPersona, Long solicitudTSUBIRDOCUMENTOATOptpatrTipo) throws SystemException;

    Collection<DocumentoG> assocOperator278Range1(Solicitud instance, Persona solicitudTSUBIRDOCUMENTOATOptPersona, Long solicitudTSUBIRDOCUMENTOATOptpatrTipo) throws SystemException;
    
    SQLPopulation assocOperator278Range1Query(Solicitud instance, Persona solicitudTSUBIRDOCUMENTOATOptPersona, Long solicitudTSUBIRDOCUMENTOATOptpatrTipo) throws SystemException;

    Collection<Usuario> assocOperator279(Solicitud instance, Persona solicitudTSUBIRDOCUMENTOATOptPersona) throws SystemException;

    Collection<Usuario> assocOperator279Range1(Solicitud instance, Persona solicitudTSUBIRDOCUMENTOATOptPersona) throws SystemException;
    
    SQLPopulation assocOperator279Range1Query(Solicitud instance, Persona solicitudTSUBIRDOCUMENTOATOptPersona) throws SystemException;

    Boolean assocOperator280(Solicitud instance, Persona solicitudTSUBIRDOCUMENTOATOptPersona, Long solicitudTSUBIRDOCUMENTOATOptpatrTipo) throws SystemException;

    Boolean assocOperator280Range1(Solicitud instance, Persona solicitudTSUBIRDOCUMENTOATOptPersona, Long solicitudTSUBIRDOCUMENTOATOptpatrTipo) throws SystemException;
    
    SQLExists assocOperator280Range1Query(Solicitud instance, Persona solicitudTSUBIRDOCUMENTOATOptPersona, Long solicitudTSUBIRDOCUMENTOATOptpatrTipo) throws SystemException;

    Collection<PlantillaEmail> assocOperator281(Solicitud instance, Long solicitudTGETPLANTILLACORREOptTipo) throws SystemException;

    Collection<PlantillaEmail> assocOperator281Range1(Solicitud instance, Long solicitudTGETPLANTILLACORREOptTipo) throws SystemException;
    
    SQLPopulation assocOperator281Range1Query(Solicitud instance, Long solicitudTGETPLANTILLACORREOptTipo) throws SystemException;

    Boolean assocOperator282(Solicitud instance) throws SystemException;

    Boolean assocOperator282Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator282Range1Query(Solicitud instance, SQLSelect superQuery) throws SystemException;

    Collection<ReportesDominio> assocOperator283(Solicitud instance, Long solicitudTGETPLANTILLAREPORTEptTipo) throws SystemException;

    Collection<ReportesDominio> assocOperator283Range1(Solicitud instance, Long solicitudTGETPLANTILLAREPORTEptTipo) throws SystemException;
    
    SQLPopulation assocOperator283Range1Query(Solicitud instance, Long solicitudTGETPLANTILLAREPORTEptTipo) throws SystemException;

    public List<Solicitud> executeQuery(String query);

    public List<Solicitud> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
