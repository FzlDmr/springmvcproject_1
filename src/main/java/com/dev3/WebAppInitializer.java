package com.dev3;
//web.xml yerine bu classi kullaniriz
//dispatcher servletin tanimlanmasi
//configurasyon classlarinin yerini gosterme
//bu iki islem icin: AbstractAnnotationConfigDispatcherServletInitializer

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
//Dispatcher: Servlet WebAppContext->Controller,Handler Mapping, View Resolver
//            Root WebAppContext->DB ve erisim: Repositories, Services

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override//Data erisim(hibernate/jdbc) icin gerekli config class
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{
                RootContextConfig.class
        };
    }

    @Override//Controller,Handler Mapping,View Resolver(SpringMVC) ile ilgili config class
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{
                WebMvcConfig.class
        };
    }

    //http://localhost:8080/SpringMvc/student/id?id=1
    @Override//hangi url ile gelen istekleri servelt tarafindan karsilanacak
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
