package de.weltraumschaf.sample.ui;

import java.util.Date;
import java.util.function.Consumer;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.fx.core.di.ContextValue;
import org.eclipse.fx.core.event.EventBus;
import org.eclipse.fx.core.event.Topic;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class DetailPart {

//	@Inject
//	private IEclipseContext ctx;
	@Inject
	private EventBus b;
	@Inject
	@ContextValue("currentTime")
	private Consumer<Date> publisher;
	
	static final Topic<Date> TOPIC = new Topic<>("my/topic"); 
	@PostConstruct
	void init(BorderPane parent) {
		Button value = new Button("Hello, World!");
		value.setOnAction(this::publishTime);
		parent.setCenter(value);
	}
	
	private void publishTime(ActionEvent e) {
		Date d = new Date();
		publisher.accept(d);
		b.publish(TOPIC, d, true);
	}
}
