package designfortestability.exercises;

public class CommandsToCollaborator {

    private StringBuilder sql = new StringBuilder();

    public void addServerClause(String[] servers) {
        //lots of code...
        addClause("NUM_SAM_SYSMON_HOST_ID", servers);
        //lots of code...
    }

    private void addClause(String columnName, String[] values) {
        if (values != null && values.length > 0) {
            sql.append(" AND ").append(columnName);
            if (values.length == 1) {
                sql.append(" = ").append(values[0]);
            } else {
                sql.append(" IN(");
                sql.append(values[0]);
                for (int i = 1; i < values.length; i++) {
                    sql.append(",").append(values[i]);
                }
                sql.append(")");
            }
        }
    }

}
