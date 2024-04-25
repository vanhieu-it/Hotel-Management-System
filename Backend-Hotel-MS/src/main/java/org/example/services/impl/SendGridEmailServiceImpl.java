package org.example.services.impl;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Attachments;
import com.sendgrid.helpers.mail.objects.Email;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.example.exception.BadRequestException;
import org.example.services.EmailService;
import org.example.services.config.SendGridProperties;
import org.example.util.DynamicTemplatePersonalization;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Service
public class SendGridEmailServiceImpl implements EmailService {

  private final SendGridProperties sendGridProperties;

  @Override
  public void sendHtmlMessage(String to, String templateId,
      DynamicTemplatePersonalization dynamicTemplatePersonalization) {

    SendGrid sg = new SendGrid(sendGridProperties.getApiKey());
    sg.addRequestHeader("X-Mock", "true");

    Request request = new Request();

    try {
      Mail dynamicTemplate = buildDynamicTemplate(to, templateId, dynamicTemplatePersonalization);
      request.setMethod(Method.POST);
      request.setEndpoint("mail/send");
      request.setBody(dynamicTemplate.build());
      sg.api(request);

    } catch (IOException ex) {
      // TODO
      throw new BadRequestException("send-mail-in-failure");
    }
  }

  @Override
  public void sendHtmlMessageWithAttachment(String to, String templateId,
      DynamicTemplatePersonalization dynamicTemplatePersonalization,
      List<Attachments> attachments) {

    SendGrid sg = new SendGrid(sendGridProperties.getApiKey());
    sg.addRequestHeader("X-Mock", "true");

    Request request = new Request();

    try {
      Mail dynamicTemplate = buildDynamicTemplate(to, templateId, dynamicTemplatePersonalization,
          attachments);
      request.setMethod(Method.POST);
      request.setEndpoint("mail/send");
      request.setBody(dynamicTemplate.build());
      sg.api(request);

    } catch (IOException ex) {
      // TODO
      throw new BadRequestException("send-mail-in-failure");
    }
  }

  private Mail buildDynamicTemplate(String to, String templateId,
      DynamicTemplatePersonalization dynamicTemplatePersonalization)
      throws IOException {

    Mail mail = new Mail();
    Email fromEmail = new Email();
    fromEmail.setName(sendGridProperties.getName());
    fromEmail.setEmail(sendGridProperties.getFromMail());
    mail.setFrom(fromEmail);

    dynamicTemplatePersonalization.addTo(new Email(to));
    mail.addPersonalization(dynamicTemplatePersonalization);
    mail.setTemplateId(templateId);

    return mail;
  }

  private Mail buildDynamicTemplate(String to, String templateId,
      DynamicTemplatePersonalization dynamicTemplatePersonalization, List<Attachments> attachments)
      throws IOException {

    Mail mail = new Mail();
    Email fromEmail = new Email();
    fromEmail.setName(sendGridProperties.getName());
    fromEmail.setEmail(sendGridProperties.getFromMail());
    attachments.stream().forEach(attachment -> mail.addAttachments(attachment));
    mail.setFrom(fromEmail);

    dynamicTemplatePersonalization.addTo(new Email(to));
    mail.addPersonalization(dynamicTemplatePersonalization);
    mail.setTemplateId(templateId);

    return mail;
  }

}

