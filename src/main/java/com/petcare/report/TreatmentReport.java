
package com.petcare.report;

import com.petcare.util.DBConnection;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class TreatmentReport {

    public static void showReport() {

        try {

            Connection connection = DBConnection.getConnection();

            // Load JRXML from resources
            InputStream reportStream =
                    TreatmentReport.class.getResourceAsStream(
                            "/reports/TreatmentReport.jrxml"
                    );

            if (reportStream == null) {

                JOptionPane.showMessageDialog(
                        null,
                        "TreatmentReport.jrxml could not be found.",
                        "Report Error",
                        JOptionPane.ERROR_MESSAGE
                );

                connection.close();
                return;
            }

            JasperReport jasperReport =
                    JasperCompileManager.compileReport(reportStream);

            Map<String, Object> parameters =
                    new HashMap<>();

            JasperPrint jasperPrint =
                    JasperFillManager.fillReport(
                            jasperReport,
                            parameters,
                            connection
                    );

            JasperViewer.viewReport(
                    jasperPrint,
                    false
            );

            connection.close();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(
                    null,
                    "Database connection error:\n"
                    + e.getMessage(),
                    "Report Error",
                    JOptionPane.ERROR_MESSAGE
            );

            e.printStackTrace();

        } catch (JRException e) {

            JOptionPane.showMessageDialog(
                    null,
                    "Jasper report error:\n"
                    + e.getMessage(),
                    "Report Error",
                    JOptionPane.ERROR_MESSAGE
            );

            e.printStackTrace();

            if (e.getCause() != null) {

                System.out.println(
                        "CAUSE: " + e.getCause()
                );

                e.getCause().printStackTrace();
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    null,
                    "Unexpected error:\n"
                    + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );

            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        showReport();

    }
}

