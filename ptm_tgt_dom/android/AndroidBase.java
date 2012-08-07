import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import no.esito.genova.model.core.QObject;
import no.esito.genova.model.dialogmodel.QDialogModelRoot;
import no.esito.genova.model.project.QDialogModelFile;


public class AndroidBase extends GenovaBase {
	
	
	@Override
	public CharSequence call() {
		return super.call();
	}
	
	public QDialogModelFile getDialogModelRef(){
		return (QDialogModelFile) context;
	}

	public QDialogModelRoot getDialogModelRoot(){
		return (QDialogModelRoot) getDialogModelRef().getModelRoot();
	}

	public void saveFile(String filename,CharSequence content){
		try {
			FileOutputStream os = new FileOutputStream(outputdir+"/"+filename);
			os.write(content.toString().getBytes());
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public CharSequence visit(QObject go){
		return "";
	}
	
	public CharSequence walk(QObject parent){
		final StringBuilder sb=new StringBuilder();
		for (QObject go : parent.<QObject>getChildren())
			sb.append(visit(go));
		return sb.toString();
	}
	

}
