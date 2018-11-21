package br.ufsc.bridge.mpiclient.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import lombok.extern.slf4j.Slf4j;

import org.xml.sax.Attributes;

@Slf4j
public class XmlAttributesWrapper {

	private Attributes attr;

	private XmlAttributesWrapper(Attributes attr) {
		this.attr = attr;
	}

	public static XmlAttributesWrapper wrap(Attributes attr) {
		return new XmlAttributesWrapper(attr);
	}

	public String get(String qName) {
		return this.attr.getValue(qName);
	}

	public LocalDate getLocalDate(String qName) {
		String value = this.attr.getValue(qName);

		if (value != null) {
			if (value.contains(".")) {
				value = value.substring(0, value.indexOf('.'));
			}
			try {
				return LocalDate.parse(value, DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
			} catch (DateTimeParseException e) {
				if (log.isDebugEnabled()) {
					log.debug("Error parsing date as yyyyMMddHHmmss.", e);
				}
				return LocalDate.parse(value, DateTimeFormatter.ofPattern("yyyyMMdd"));
			}
		}
		return null;
	}

}
