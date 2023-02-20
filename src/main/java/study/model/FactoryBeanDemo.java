package study.model;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Service;

/**
 * Created by crist on 2022/9/21
 *
 * @author cc
 */
@Service
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
