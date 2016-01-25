package th.ac.kmutt.chart.rest.resource;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.restlet.representation.Representation;
import org.restlet.representation.Variant;
import org.restlet.resource.ResourceException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import th.ac.kmutt.chart.dwh.domain.InboundOutboundStudent;
import th.ac.kmutt.chart.model.InBoundOutBoundServiceM;
import th.ac.kmutt.chart.service.ChartService;
import th.ac.kmutt.chart.xstream.common.ImakeResultMessage;
import th.ac.kmutt.chart.xstream.common.Paging;

/**
 * Created by imake on 20/10/2015.
 */
public class InBoundOutBoundResource  extends BaseResource {
   // private static final Logger logger = Logger.getLogger(ServiceConstant.LOG_APPENDER);
    @Autowired
    @Qualifier("chartServiceJpaImpl")
    private ChartService chartService;

    @Autowired
    private com.thoughtworks.xstream.XStream xstream;
    @Autowired
    private com.thoughtworks.xstream.XStream jsonXstream;
    public InBoundOutBoundResource() {
        super();
        logger.debug("into constructor TitleResource");
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void doInit() throws ResourceException {
        // TODO Auto-generated method stub
        super.doInit();
        logger.debug("into doInit");
    }

    @Override
    protected Representation post(Representation entity, Variant variant)
            throws ResourceException {
        // TODO Auto-generated method stub
        logger.debug("into Post ConsultantReportResource 2");
        InputStream in = null;
        try {
            in = entity.getStream();
            xstream.processAnnotations(InBoundOutBoundServiceM.class);// or xstream.autodetectAnnotations(true); (Auto-detect  Annotations)
            InBoundOutBoundServiceM xsource = new InBoundOutBoundServiceM();
            Object xtarget = xstream.fromXML(in);
            if (xtarget != null) {
                xsource = (InBoundOutBoundServiceM) xtarget;
                if (xsource != null) {
                    InboundOutboundStudent domain = new InboundOutboundStudent();
                    BeanUtils.copyProperties(xsource, domain);
                    if (xsource.getServiceName() != null
                            && xsource.getServiceName().length() != 0) {
                        String serviceName = xsource.getServiceName();

                        Paging page = xsource.getPaging();
                        @SuppressWarnings("rawtypes")
                        ArrayList<InboundOutboundStudent> domains = (ArrayList<InboundOutboundStudent>)
                                chartService.allStudentCompareInternational(xsource);
                        List<InBoundOutBoundServiceM> models = new ArrayList<InBoundOutBoundServiceM>(domains.size());
                        models = getInBoundOutBoundServiceModels(domains);
                        ImakeResultMessage imakeMessage = new ImakeResultMessage();
                        imakeMessage.setResultListObj(models);
                        return getRepresentation(entity, imakeMessage, xstream);

                        /*
                        JsonRepresentation representation_aoe = null;


                        jsonXstream
                                .processAnnotations(th.ac.kmutt.chart.model.JournalPapersServiceM.class);// or
                        jsonXstream.autodetectAnnotations(true);
                        jsonXstream.setMode(XStream.NO_REFERENCES);
                        // jsonXstream.addImplicitCollection(models.getClass(), "TitleM");;
                        Gson gson = new Gson();
                        String jsonStr= gson.toJson(models);
                        System.out.println("json->" + jsonStr);
                        String json = jsonXstream.toXML(models);
                        System.out.println("json->"+json);

                        representation_aoe = new JsonRepresentation(jsonStr);

                        return representation_aoe;
                        */
                    } else {
                    }
                }

            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            logger.debug(" into Finally Call");
            try {
                if (in != null)
                    in.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;

    }

    private List<InBoundOutBoundServiceM> getInBoundOutBoundServiceModels(
            ArrayList<InboundOutboundStudent> domains) {
        List<InBoundOutBoundServiceM> models = new ArrayList<InBoundOutBoundServiceM>(
                domains.size());
        for (InboundOutboundStudent domain : domains) {
        	InBoundOutBoundServiceM model = new InBoundOutBoundServiceM();
            BeanUtils.copyProperties(domain, model);

            model.setAcademicYear(domain.getAcademicYear());
            model.setFacultyKey(domain.getFacultyKey());    
            model.setNoOfStudent(domain.getNoOfStudent());
            model.setPaging(null);
            models.add(model);
            
        }
        return models;
    }
    
    @Override
    protected Representation get(Variant variant) throws ResourceException {
       
        return null;
    }
}
