package com.zzg.mybatis.generator;

import com.zzg.mybatis.generator.controller.MainUIController;
import com.zzg.mybatis.generator.util.ConfigHelper;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.io.File;
import java.net.URL;

/**
 * 这是本软件的主入口,要运行本软件请直接运行本类就可以了,不用传入任何参数
 * 本软件要求jkd版本大于1.8.0.40
 */
public class MainUI extends Application {

	private static final Logger _LOG = LoggerFactory.getLogger(MainUI.class);

	@Override
	public void start(Stage primaryStage) throws Exception {
		ConfigHelper.createEmptyFiles();
		URL url = Thread.currentThread().getContextClassLoader().getResource("fxml/MainUI.fxml");
		FXMLLoader fxmlLoader = new FXMLLoader(url);
		Parent root = fxmlLoader.load();
		primaryStage.setResizable(true);
		primaryStage.setScene(new Scene(root));
		primaryStage.show();

		MainUIController controller = fxmlLoader.getController();
		controller.setPrimaryStage(primaryStage);
	}

	public static void main(String[] args) {
		//解决 java.lang.UnsatisfiedLinkError: C:\Users\luo_d\AppData\Local\Temp\sqlite-3.8.11.2-361a1aec-70b3-4143-953f-b29105263e11-sqlitejdbc.dll: 拒绝访问。
		System.setProperty("java.io.tmpdir","D:/temp");
		File tmp = new File(System.getProperty("java.io.tmpdir"));
		if (!tmp.exists() || !tmp.isDirectory() || !tmp.canRead() || !tmp.canWrite()) {
			System.out.println("error with tmpDir");
			return;
		}

		launch(args);
	}

}
