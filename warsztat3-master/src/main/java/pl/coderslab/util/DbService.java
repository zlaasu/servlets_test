package pl.coderslab.util;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DbService {

    private static DbService INSTANCE = null;

    private DbService(){}
    public static DbService getInstance(){
        if(INSTANCE==null){
            INSTANCE = new DbService();
        }
        return INSTANCE;
    }


    /**
     * Execute insert query and return id of created element, if not then null
     * @param query
     * @param params
     * @return id or null
     * @throws SQLException
     */
    public Integer insertInto(String query, String... params) throws SQLException{
        if(params.length>0) {
            return insertIntoDatabase(query, Arrays.asList(params));
        }else{
            return insertIntoDatabase(query, null);
        }
    }
    public Integer insertIntoDatabase(String query, List<String> params) throws SQLException {

        try(Connection conn = DbUtil.getConnection()){

            String[] generatedColumns = {"id"};
            PreparedStatement pst = conn.prepareStatement(query, generatedColumns);
            if(params != null) {
                int i = 1;
                for (String p : params) {
                    pst.setString(i++, p);
                }
            }

            pst.executeUpdate();

            ResultSet res = pst.getGeneratedKeys();

            if(res.next())
                return res.getInt(1);
            else
                return null;
        }catch (SQLException e ){
            throw e;
        }

    }
    public Result execute(String query, String... args) throws SQLException{
        Result result = new Result();
        if(query.trim().toUpperCase().startsWith("SELECT")){
            result.rows = getData(query,args);
        }else if(query.trim().toUpperCase().startsWith("UPDATE") || query.trim().toUpperCase().startsWith("DELETE")
                || query.trim().toUpperCase().startsWith("DROP") || query.trim().toUpperCase().startsWith("INSERT") || query.trim().toUpperCase().startsWith("ALTER")){
            result.affectedRowsCount = executeUpdate(query,args);
        }else{
            throw new RuntimeException("Wrong STATEMENT");
        }
        return result;
    }

    public List<String[]> getData(String query,  String... params) throws SQLException{

        try(Connection conn = DbUtil.getConnection()){

            //prepare query
            PreparedStatement st = getPreparedStatement(query, conn, params);
            //execute and get results
            ResultSet rs = st.executeQuery();

            //get columns from query
            ResultSetMetaData columns = rs.getMetaData();

            //prepare list of results
            List<String[]> result = new ArrayList<>();

            while(rs.next()){

                //New String array for row data
                String[] row = new String[columns.getColumnCount()];

                for(int j=1; j<=columns.getColumnCount(); j++){
                    row[j-1] = rs.getString( columns.getColumnName(j) );
                }

                result.add(row);
            }

            return result;

        }catch (SQLException e){
            throw e;
        }

    }

    private PreparedStatement getPreparedStatement(String query, Connection conn, String... params) throws SQLException {
        PreparedStatement st = conn.prepareStatement(query);
        if(params!=null) {
            int i = 1;
            for (String p : params) {
                st.setString(i++, p);
            }
        }
        return st;
    }

    public int executeUpdate(String query, String... params)
            throws SQLException {
        try(Connection conn = DbUtil.getConnection()) {
            PreparedStatement st = getPreparedStatement(query, conn, params);
            return st.executeUpdate();
        }catch(SQLException e){
            throw e;
        }
    }

    public class Result{
        private Integer affectedRowsCount;
        private List<String[]> rows;

        public Integer getAffectedRowsCount() {
            return affectedRowsCount;
        }

        public List<String[]> getRows() {
            return rows;
        }
    }

}
