package kr.re.keti.disposable.taskservice.category;

import org.apache.ibatis.type.EnumTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TypeHandler extends EnumTypeHandler<Type> {

    public TypeHandler(Class<Type> type) {
        super(type);
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Type parameter, JdbcType jdbcType) throws SQLException {
        if(parameter != null) {
            ps.setString(i, parameter.getName());
        } else  {
            ps.setString(i, null);
        }
    }

    @Override
    public Type getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String result = rs.getString(columnName);
        System.out.println(result);
        try {
            Type string = Type.getString(result);
            System.out.println(string);
            return string;
        } catch (IllegalArgumentException e){
            return null;
        }
    }

    @Override
    public Type getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String result = rs.getString(columnIndex);
        try {
            return Type.getString(result);
        } catch (IllegalArgumentException e){
            return null;
        }
    }

    @Override
    public Type getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String result = cs.getString(columnIndex);
        try {
            return Type.getString(result);
        } catch (IllegalArgumentException e){
            return null;
        }
    }
}
