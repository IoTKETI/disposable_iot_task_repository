package kr.re.keti.disposable.taskservice.task;

import org.apache.ibatis.type.EnumTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataTypeHandler extends EnumTypeHandler<DataType> {


    public DataTypeHandler(Class<DataType> type) {
        super(type);
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, DataType parameter, JdbcType jdbcType) throws SQLException {
        if(parameter != null) {
            ps.setString(i, parameter.getCode());
        } else  {
            ps.setString(i, null);
        }
    }

    @Override
    public DataType getResult(ResultSet rs, String columnName) throws SQLException {
        String result = rs.getString(columnName);
        try {
            return DataType.getString(result);
        } catch (IllegalArgumentException e){
            return null;
        }
    }

    @Override
    public DataType getResult(ResultSet rs, int columnIndex) throws SQLException {
        String result = rs.getString(columnIndex);
        try {
            return DataType.getString(result);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    @Override
    public DataType getResult(CallableStatement cs, int columnIndex) throws SQLException {
        String result = cs.getString(columnIndex);
        try {
            return DataType.getString(result);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
