package com.ticketreservation.util;

import java.awt.Color;
import java.io.ByteArrayOutputStream;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.ticketreservation.entiry.PassengerInfo;
import com.ticketreservation.entiry.TicketReservation;

public class PDFGeneratorUtil2 {

    public static byte[] generateTicketPDF(String pnrNo, PassengerInfo passengerInfo, TicketReservation ticket) throws Exception {
    	 ByteArrayOutputStream out = new ByteArrayOutputStream();
         Document document = new Document(PageSize.A4);
         PdfWriter.getInstance(document, out);
         document.open();

         Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, Color.BLUE);
         Font headerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12);
         Font bodyFont = FontFactory.getFont(FontFactory.HELVETICA, 11);

         // Title
         Paragraph title = new Paragraph("Indian Railway e-Ticket Confirmation", titleFont);
         title.setAlignment(Element.ALIGN_CENTER);
         title.setSpacingAfter(10);
         document.add(title);

         // Journey Details Table
         PdfPTable journeyTable = new PdfPTable(4);
         journeyTable.setWidthPercentage(100);
         journeyTable.setSpacingAfter(10);

         journeyTable.addCell(getCell("Train No:", headerFont));
         journeyTable.addCell(getCell(ticket.getTrainCode(), bodyFont));
         journeyTable.addCell(getCell("From Station:", headerFont));
         journeyTable.addCell(getCell(ticket.getFromStation(), bodyFont));
         journeyTable.addCell(getCell("To Station:", headerFont));
         journeyTable.addCell(getCell(ticket.getToStation(), bodyFont));

         journeyTable.addCell(getCell("Journey Date:", headerFont));
         journeyTable.addCell(getCell(""+ticket.getFromDate(), bodyFont));
//         journeyTable.addCell(getCell("Quota:", headerFont));
//         journeyTable.addCell(getCell(passengerInfo.getSeatNo(), bodyFont));

         journeyTable.addCell(getCell("From:", headerFont));
         journeyTable.addCell(getCell(ticket.getFromStation(), bodyFont));
         journeyTable.addCell(getCell("To:", headerFont));
         journeyTable.addCell(getCell(ticket.getToStation(), bodyFont));

         document.add(journeyTable);

         // Passenger Table
         PdfPTable paxTable = new PdfPTable(6);
         paxTable.setWidthPercentage(100);
         paxTable.setWidths(new float[]{1, 3, 1, 1, 2, 1});

         paxTable.addCell(getHeaderCell("S.No"));
         paxTable.addCell(getHeaderCell("Name"));
         paxTable.addCell(getHeaderCell("Age"));
         paxTable.addCell(getHeaderCell("Gender"));
         paxTable.addCell(getHeaderCell("PnrNumber"));
         paxTable.addCell(getHeaderCell("Seat No"));

         paxTable.addCell(getCell("1", bodyFont));
         paxTable.addCell(getCell(passengerInfo.getPassengerName(), bodyFont));
         paxTable.addCell(getCell(String.valueOf(passengerInfo.getPassengerAge()), bodyFont));
         paxTable.addCell(getCell(passengerInfo.getPassengerGender(), bodyFont));
         paxTable.addCell(getCell(passengerInfo.getPnr_no(), bodyFont));
         paxTable.addCell(getCell(passengerInfo.getSeatNo(), bodyFont));

         document.add(paxTable);

         // Fare & PNR
         Paragraph info = new Paragraph("PNR No: " + ticket.getPnrNo() + "\nTotal Fare: ₹" + passengerInfo.getFare(), bodyFont);
         info.setSpacingBefore(10);
         document.add(info);

         document.close();
         return out.toByteArray();

    }
    
    private static PdfPCell getCell(String content, Font font) {
        PdfPCell cell = new PdfPCell(new Phrase(content, font));
        cell.setPadding(5);
        return cell;
    }

    private static PdfPCell getHeaderCell(String content) {
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 11, Color.WHITE);
        PdfPCell cell = new PdfPCell(new Phrase(content, font));
        cell.setBackgroundColor(Color.GRAY);
        cell.setPadding(5);
        return cell;
    }

}
