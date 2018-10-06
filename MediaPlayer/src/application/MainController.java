package application;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;

public class MainController implements Initializable{

	@FXML private MediaView mv;
	@FXML private Button btn1;
	@FXML private Slider volumeSlider;
	private String filePath;
	private MediaPlayer mediaPlayer;
	
	@FXML
	public void handleButtonAction(ActionEvent event){
		FileChooser fileChooser = new FileChooser();
	//	FileChooser.ExtensionFilter filter = new FileChooser().ExtensionFilter("Mp4 file please", ".mp4");
	//	fileChooser.getExtensionFilters().add(filter);
		File file = fileChooser.showOpenDialog(null);
		filePath = file.toURI().toString();
		if(filePath != null){
			Media media = new Media(filePath);
			mediaPlayer = new MediaPlayer(media);
			mv.setMediaPlayer(mediaPlayer);
		//	mediaPlayer.setAutoPlay(true);
			DoubleProperty width = mv.fitWidthProperty();
			DoubleProperty height = mv.fitHeightProperty();
			width.bind(Bindings.selectDouble(mv.sceneProperty(), "width"));
			height.bind(Bindings.selectDouble(mv.sceneProperty(), "height"));
			/*volumeSlider.setValue(mediaPlayer.getVolume() * 100);
		    volumeSlider.valueProperty().addListener(new InvalidationListener(){

				@Override
				public void invalidated(Observable observable) {
					// TODO Auto-generated method stub
					mediaPlayer.setVolume(volumeSlider.getValue() / 100);
				}
		    });*/
		}
		}
		
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		 
		
	}
	public void volumeSlider(ActionEvent event){
		 
	}
	public void play(ActionEvent event){
		mediaPlayer.play();
		mediaPlayer.setRate(1);
	}
	public void pause(ActionEvent event){
		mediaPlayer.pause();
	}
	public void fast(ActionEvent event){
		mediaPlayer.setRate(2);
	}
	public void slow(ActionEvent event){
		mediaPlayer.setRate(.5);
	}
	public void reload(ActionEvent event){
		mediaPlayer.seek(mediaPlayer.getStartTime());
		mediaPlayer.play();
	}
	public void start (ActionEvent event){
		mediaPlayer.seek(mediaPlayer.getStartTime());
		mediaPlayer.stop();
	}
	public void last(ActionEvent event){
		mediaPlayer.seek(mediaPlayer.getTotalDuration());
		mediaPlayer.stop();
	}

}
