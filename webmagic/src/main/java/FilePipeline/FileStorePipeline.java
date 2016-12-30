package FilePipeline;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.omg.CORBA_2_3.portable.OutputStream;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import com.renby.webmagic.ExtendResultItems;

public class FileStorePipeline implements Pipeline{
	private Set<String> fileTypes = new HashSet<String>();
	
	private File parentPath;
	
	public FileStorePipeline(String path){
		parentPath = new File(path);
		if(!parentPath.exists()){
			parentPath.mkdirs();
		}

		fileTypes.add("image/png");
		fileTypes.add("image/gif");
		fileTypes.add("image/jpg");
	}
	
	public void process(ResultItems resultItems, Task task) {
		if(!(resultItems instanceof ExtendResultItems)){
			return;
		}
		ExtendResultItems result = (ExtendResultItems) resultItems;
		if(!fileTypes.contains(result.getContentType())){
			return;
		}
		
		FileOutputStream output = null;
		try{
			File parent = getParent(result, task);
			String fileName = getFileName(result, task);
			output = new FileOutputStream(new File(parent, fileName));
			output.write(result.getContentBytes());
			output.flush();
		}catch(Exception e){
			
		}finally{
			if(output != null){
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private File getParent(ExtendResultItems resultItems, Task task){
		return parentPath;
	}
	
	private String getFileName(ExtendResultItems resultItems, Task task){
		String url = resultItems.getRequest().getUrl();
		String fileName;
		if(url.indexOf("?") > 0){
			fileName = url.substring(url.lastIndexOf("/") + 1, url.lastIndexOf("?"));
		}else{
			fileName = url.substring(url.lastIndexOf("/") + 1);
		}
		return fileName;
	}
}
