package mn.infosystems.callcenter.action;

import java.text.SimpleDateFormat;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

import mn.infosystems.callcenter.model.Calls;
import mn.infosystems.callcenter.model.Debt;
import mn.infosystems.callcenter.model.TaxPayer;

public class EmailSwingWorker extends SwingWorker<TaxPayer, Long> {

	Session session;
	String host;
	String from = "altansuldp@gmail.com";
	String password = "um19920211";
	TaxPayer taxPayer;

	public EmailSwingWorker(TaxPayer tp) {
		this.taxPayer = tp;
	}

	public void prepare() {
		host = "smtp.gmail.com";
		Properties props = System.getProperties();
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.user", from);
		props.put("mail.smtp.password", password);
		props.put("mail.smtp.port", 587);
		props.put("mail.smtp.auth", "true");
		session = Session.getDefaultInstance(props, null);
	}

	public boolean sendMail() {
		prepare();
		try {
			MimeMessage mimeMessage = new MimeMessage(session);
			mimeMessage.setFrom(new InternetAddress(from));
			InternetAddress address = new InternetAddress(taxPayer.getEmail());
			mimeMessage.addRecipient(RecipientType.TO, address);

			mimeMessage.setSubject("Татварын ерөнхий газар өр дуудах төв ");
			mimeMessage.setText(message());

			MimeMultipart multipart = new MimeMultipart("related");

			BodyPart messageBodyPart = new MimeBodyPart();
			String htmlText = "<H1>МТА ӨР ДУУДАХ ТӨВ</H1><img src=\"cid:image\">";
			htmlText += "<br>" + message();
			messageBodyPart.setContent(htmlText, "text/html;charset=UTF-8");

			multipart.addBodyPart(messageBodyPart);
/*
			messageBodyPart = new MimeBodyPart();
			DataSource fds = new FileDataSource(
					"C:/Users/Suld/Pictures/image.jpg");

			messageBodyPart.setDataHandler(new DataHandler(fds));
			messageBodyPart.setHeader("Content-ID", "<image>");
*/
			multipart.addBodyPart(messageBodyPart);

			mimeMessage.setContent(multipart);

			Transport transport = session.getTransport("smtp");
			transport.connect(host, from, password);
			transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
			transport.close();
			return true;
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return false;
	}

	public String message() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String str = "<font size=\"6\">";
		str += taxPayer.getCompanyName() + " танай компани нь :<br>";
		for (Debt debt : taxPayer.getActiveDebtList()) {
			str += formatter.format(debt.getStartDate()) + " өдөр үүссэн " + debt.getBalance()
					+ " төгрөгний " + debt.getEndDate() + " өдөр дуусах <br>";
		}
		str += "гэсэн татварын өрүүдтэй байна. <br>";

		for (Calls call : taxPayer.getCalls()) {
			str += formatter.format(call.getDate()) + "  " + call.getReason().getDescription()
					+ "<br>";
		}

		str += "Иймд та өөрийн татварын өрөө цаг тухайд нь төлнө үү";
		
		str += "</font>";
		
		return str;
	}

	@Override
	protected TaxPayer doInBackground() throws Exception {
		sendMail();
		return null;
	}

}
