/*
 * Copyright (C) 2017 rafael.lopes
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package joaninha.util;

//import com.thoughtworks.xstream.XStream;
//import com.thoughtworks.xstream.io.xml.DomDriver;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.InputStream;
//import java.net.URL;
//import java.net.UnknownHostException;
//import joaninha.dao.LogErroJpaController;
//import joaninha.dao.LogSistemaJpaController;
//import joaninha.modelos.Config;
//import joaninha.modelos.LogSistema;

/**
 *
 * @author rafael.lopes
 */
public class Sistema {

//    private URL u = getClass().getClassLoader().getResource("Xml/arquivos.xml");
//
//    public LogSistema getSistema() throws Exception {
//        LogSistema logSistema = null;
//        LogSistemaJpaController logSistemaDao = new LogSistemaJpaController();
//        try {
//            logSistema = logSistemaDao.findLogSistema(1);
//        } catch (Exception ex) {
//            LogErroJpaController logErroDAO = new LogErroJpaController();
//            logErroDAO.logSQLException(ex, "getNewVersion");
//        }
//        return logSistema;
//    }
//
//    public double getSystemVersion() {
//        XStream xStream = new XStream(new DomDriver());
//        Double versao;
//        try {
//            if (u.getProtocol().equals("jar")) {
//                InputStream input = getClass().getResourceAsStream("/Xml/arquivos.xml");
//                xStream.alias("config", Config.class);
//                Config xml = (Config) xStream.fromXML(input);
//                versao = xml.getVersao();
//            } else {
//                File f = new File(u.getFile());
//                FileInputStream input = new FileInputStream(f);
//                xStream.alias("config", Config.class);
//                Config xml = (Config) xStream.fromXML(input);
//                versao = xml.getVersao();
//            }
//        } catch (FileNotFoundException | NullPointerException | SecurityException ex) {
//            return 0.0;
//        }
//        return versao;
//    }
//
//    public Boolean systemUpdate() throws Exception {
//        return getSystemVersion() < getSistema().getSistemaVersao();
//    }

//    public void updateSystemLog_Off(Boolean on_off) {
//        Connection conn = ConnectionFactory.getConnection();
//        PreparedStatement stmt = null;
//        try {
//            stmt = conn.prepareStatement("UPDATE tb_log_off SET "
//                    + "log_off = ? WHERE id = 1");
//            stmt.setInt(1, on_off ? 1 : 0);
//            stmt.executeUpdate();
//        } catch (SQLException ex) {
//            LogDAO logDAO = new LogDAO();
//            logDAO.logSQLException(ex, "updateSystemLog_Off");
//        } finally {
//            ConnectionFactory.closeConection(conn, stmt);
//        }
//    }
//    public void updateSystemVersion(Double versao) {
//        Connection conn = ConnectionFactory.getConnection();
//        PreparedStatement stmt = null;
//        try {
//            stmt = conn.prepareStatement("UPDATE tb_log_sistema SET "
//                    + "sistema_data = ?, sistema_criador = ?, sistema_versao = ? "
//                    + "WHERE log_sistema_id = 1");
//            stmt.setTimestamp(1, DataHora.getTimestampDate(new Date()));
//            stmt.setString(2, System.getProperty("user"));
//            stmt.setDouble(3, versao);
//            stmt.executeUpdate();
//        } catch (SQLException ex) {
//            LogDAO logDAO = new LogDAO();
//            logDAO.logSQLException(ex, "updateSystemVersion");
//        } finally {
//            ConnectionFactory.closeConection(conn, stmt);
//        }
//    }
    
    
//    public static String getComputador() {
//        try {
//            return java.net.InetAddress.getLocalHost().getHostName();
//        } catch (UnknownHostException ex1) {
//            return null;
//        }
//    }

}
