package cn.fudan.lib.stream.database;

import cn.fudan.lib.app.xyj.ExceptionParameter;
import cn.fudan.lib.dao.MySqlSessionFactory;
import cn.fudan.lib.dto.DataItem;
import cn.fudan.lib.dto.DeviceInfo;
import cn.fudan.lib.dto.DeviceInfoQueryParameter;
import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.session.SqlSession;
import cn.fudan.lib.app.xr.DeviceInfoDataItem;

import java.util.List;

/**
 * 设置为单例模式
 */
public enum QueryData {
    INSTANCE;

    public List<DataItem> query (QueryParameter parameter) {
        checkParameter(parameter);
        SqlSession sqlSession = MySqlSessionFactory.createSqlSession().openSession();
        DaoMapper mapper = sqlSession.getMapper(DaoMapper.class);
        List<DataItem> dataItemList = null;

        try {
            dataItemList = mapper.readData(parameter);
        } finally {
            if (sqlSession != null)
                sqlSession.close();
        }

        return dataItemList;
    }

    public List<String> getAllDeviceId(QueryParameter parameter){
        checkParameter(parameter);
        SqlSession sqlSession = MySqlSessionFactory.createSqlSession().openSession();
        DaoMapper mapper = sqlSession.getMapper(DaoMapper.class);
        List<String> dataItemList = null;

        try {
            dataItemList = mapper.queryAllDeviceId(parameter);
        } finally {
            if (sqlSession != null)
                sqlSession.close();
        }

        return dataItemList;
    }
  
    public void postExceptionData(ExceptionParameter parameter){
        SqlSession sqlSession = MySqlSessionFactory.createSqlSession().openSession();
        DaoMapper mapper = sqlSession.getMapper(DaoMapper.class);

        try {
            mapper.insertExceptionData(parameter);
            sqlSession.commit();
        } catch (Exception e) {
            System.out.println("Caught Exception");
            System.out.println("getMessage():" + e.getMessage());
            System.out.println("getLocalizedMessage():" +
                    e.getLocalizedMessage());
            System.out.println("toString()" + e);
            System.out.println("printStackTrace():");
            e.printStackTrace(System.out);
        } finally {
            if (sqlSession != null)
                sqlSession.close();
            System.out.println("successful  " + JSONObject.toJSONString(parameter));
        }
    }
  
    public List<DeviceInfoDataItem> queryDeviceInfo (QueryParameter parameter) {
//        checkParameter(parameter);
        SqlSession sqlSession = MySqlSessionFactory.createSqlSession().openSession();
        DaoMapper mapper = sqlSession.getMapper(DaoMapper.class);
        List<DeviceInfoDataItem> deviceInfoDataItem = null;

        try {
            deviceInfoDataItem = mapper.readDeviceInfo(parameter);
        } finally {
            if (sqlSession != null)
                sqlSession.close();
        }
        return deviceInfoDataItem;
    }

    public DeviceInfo queryDeviceAddress (DeviceInfoQueryParameter parameter) {
//        checkParameter(parameter);
        SqlSession sqlSession = MySqlSessionFactory.createSqlSession().openSession();
        DaoMapper mapper = sqlSession.getMapper(DaoMapper.class);
        DeviceInfo deviceInfoDataItem = null;

        try {
            deviceInfoDataItem = mapper.getDeviceAddress(parameter);
        }catch (Exception e) {
            System.out.println("Caught Exception");
            System.out.println("getMessage():" + e.getMessage());
            System.out.println("getLocalizedMessage():" +
                    e.getLocalizedMessage());
            System.out.println("toString()" + e);
            System.out.println("printStackTrace():");
            e.printStackTrace(System.out);
        }  finally {
            if (sqlSession != null)
                sqlSession.close();
        }
        return deviceInfoDataItem;
    }


    /**
     * 为了保证数据库的安全，查询数据的时候，必须设置时间范围(开始时间和结束时间)
     * 如果一次查询的数据量太大，可能会导致数据库服务器宕机
     */
    private void checkParameter (QueryParameter parameter) {
        if (parameter.getBeginDate() == null) {
            throw new IllegalArgumentException("Please set parameter: beginDate");
        }

        if (parameter.getEndDate() == null) {
            throw new IllegalArgumentException("Please set parameter: endDate");
        }

        if (parameter.getExcludeIds() != null && parameter.getExcludeIds().size() <= 0) {
            parameter.setExcludeIds(null);
        }
    }

}
