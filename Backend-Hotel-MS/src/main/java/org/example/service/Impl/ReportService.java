package org.example.service.Impl;

import org.example.dto.QuickReportDTO;
import org.example.dto.Report;
import org.example.request.GetDateFromAndTo;

import java.util.List;

public interface ReportService {

  Report report(String billId);

  List<QuickReportDTO> quickReport();

  void makingDailyReport(String staffName, GetDateFromAndTo date);

  void makingYearLyReport(int year, String staffName);

  void makeTheBestServiceAndBookingReport(String staffName, GetDateFromAndTo date);

  List<String> getHavingValueYear(String staffName);
}
