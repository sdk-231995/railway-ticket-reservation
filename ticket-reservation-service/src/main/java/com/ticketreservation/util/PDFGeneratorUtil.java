package com.ticketreservation.util;

import java.io.ByteArrayOutputStream;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import com.ticketreservation.entiry.PassengerInfo;
import com.ticketreservation.entiry.TicketReservation;

public class PDFGeneratorUtil {

    public static byte[] generateTicketPDF(String pnrNo, PassengerInfo passengerInfo, TicketReservation ticket) throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Document doc = new Document();
        PdfWriter.getInstance(doc, baos);
        doc.open();

        doc.add(new Paragraph("Railway Ticket Booking Confirmation"));
        doc.add(new Paragraph("PNR No: " + pnrNo));
        doc.add(new Paragraph("Passenger Name: " + passengerInfo.getPassengerName()));
        doc.add(new Paragraph("Age: " + passengerInfo.getPassengerAge() + ", Gender: " + passengerInfo.getPassengerGender()));
        doc.add(new Paragraph("From: " + ticket.getFromStation() + "  To: " + ticket.getToStation()));
        doc.add(new Paragraph("Journey Date: " + ticket.getToDate()));
        doc.add(new Paragraph("Train Code: " + ticket.getTrainCode()));
        doc.add(new Paragraph("Seat No: " + passengerInfo.getSeatNo()));
        doc.add(new Paragraph("Fare: ₹" + passengerInfo.getFare()));

        doc.close();
        return baos.toByteArray();
    }
}
