package study.model;

import org.springframework.beans.factory.FactoryBean;

/**
 * Created by crist on 2022/9/21
 *
 * @author cc
 */
public class FactoryBeanDemo implements FactoryBean<SubBean> {
    @Override
    public SubBean getObject() throws Exception {
        return new SubBean();
    }

    @Override
    public Class<?> getObjectType() {
        return SubBean.class;
    }
}
