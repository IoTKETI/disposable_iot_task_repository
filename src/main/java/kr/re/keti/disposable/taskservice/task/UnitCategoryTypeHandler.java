package kr.re.keti.disposable.taskservice.task;

import org.apache.ibatis.type.EnumTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UnitCategoryTypeHandler extends EnumTypeHandler<OutPutParameter.UnitCategory> {
    public UnitCategoryTypeHandler(Class<OutPutParameter.UnitCategory> type) {
        super(type);
    }


    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, OutPutParameter.UnitCategory parameter, JdbcType jdbcType) throws SQLException {
        if(parameter != null) {
            ps.setString(i, parameter.getCode());
        } else  {
            ps.setString(i, null);
        }
    }

    @Override
    public OutPutParameter.UnitCategory getResult(ResultSet rs, String columnName) throws SQLException {
        String result = rs.getString(columnName);
        try {
            return OutPutParameter.UnitCategory.getString(result);
        } catch (IllegalArgumentException e){
            return null;
        }
    }

    @Override
    public OutPutParameter.UnitCategory getResult(ResultSet rs, int columnIndex) throws SQLException {
        String result = rs.getString(columnIndex);
        try {
            return OutPutParameter.UnitCategory.getString(result);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    @Override
    public OutPutParameter.UnitCategory getResult(CallableStatement cs, int columnIndex) throws SQLException {
        String result = cs.getString(columnIndex);
        try {
            return OutPutParameter.UnitCategory.getString(result);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
