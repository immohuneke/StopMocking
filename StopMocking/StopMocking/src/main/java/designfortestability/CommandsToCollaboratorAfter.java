package designfortestability;

import org.jetbrains.annotations.TestOnly;

public class CommandsToCollaboratorAfter {

    private StringBuilder sql = new StringBuilder();

    public void addServerClause(String[] servers) {
        //lots of code...
        sql.append(addClause("NUM_SAM_SYSMON_HOST_ID", servers));
        //lots of code...
    }

    // test this separatly
    @TestOnly
    static StringBuilder addClause(String columnName, String[] values) {
        StringBuilder addClause = new StringBuilder(100);
        if (values != null && values.length > 0) {
            addClause.append(" AND ").append(columnName);
            if (values.length == 1) {
                addClause.append(" = ").append(values[0]);
            } else {
                addClause.append(" IN(");
                addClause.append(values[0]);
                for (int i = 1; i < values.length; i++) {
                    addClause.append(",").append(values[i]);
                }
                addClause.append(")");
            }
        }
        return addClause;
    }

}
