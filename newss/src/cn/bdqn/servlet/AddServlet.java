package cn.bdqn.servlet;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.bdqn.bean.Datail;
import cn.bdqn.seriver.DatailSeriver;
import cn.bdqn.seriverImpl.DatailSeriverImpl;

public class AddServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 + * �ļ�����   ===���ϴ�
		 + * 
		 + * ������
		 + *01.form���ύ��ʱ��  ���ļ���enctype="multipart/form-data"
		 + *02.������ļ��ϴ� ������Ҫ����2��jar
		 + *   fileupload �ļ��ϴ���jar   ������  io.jar
		 + *03.���ǵ�form����  ��ֻ�����ļ������� ��ͨ�� �ı������
		 + *   ��ʱ�� ������  ����ͬһ�ַ�ʽ ���д����𣿣���  No!
		 + *04.���ļ� ���ǰ����ļ��ķ�ʽ ����  
		 + *     001.������ô֪���û����������ļ��ϴ����ͣ�
		 + *       ServletFileUpload����һ��isMultipartContent(HttpServletRequest)����
		 + *         �����û�������  ���ǿ����ж�  �Ƿ����ļ��ϴ����͵����� ���� boolean
		 + *       
		 + *       ServletFileUpload�л���һ����Ҫ�ķ���parseRequest(HttpServletRequest)
		 + *        �����û�������,�������form���е�ÿһ��������ļ�������ͨ�ı�����װ����
		 + *        һ��FileItem���������������һ������FileItem��List����
		 + *       
		 + *     002.��ô�����ļ���
		 + *      FileItem �ӿ� 
		 + *          ����һϵ�еķ���   ���Խ����Ƿ����ļ�������ͨ�ı���
		 + *           getInputStream() ���ϴ��ļ����ص��ڴ���                                       ������
		 + *           getOutputStream() ���ڴ��е�����д�뵽���������ļ���                �����
		 + *           
		 + *           ������ļ����ͣ����ȡ�ļ���ʹ�� getName()
		 + *           �������ͨ�ı������ȡ�ֶ���ʹ�� getFieldName()
		 + *          
		 + *           ��ô֪�� ���ļ� ���� ��ͨ�ֶΣ���
		 + *            ��һ������ isFormField()  ����boolean
		 + *            true :��ͨ�ֶ�
		 + *            false:�ļ�
		 + *        
		 + *       DiskFileItemFactory ���ĵ�ʵ����  
		 + *           �����������ǻ������Ĵ�С setSizeThreshold(int sizeThreshold)  1024*1024          Ĭ�ϴ�С 10kb
		 + *           �����ļ���ʱ��ŵ�λ��    setRepository(File repository)    new  File("e:\temp")    Ĭ��·��System.getProperty("java.io.temdir")
		 + *    
		 + *   ����ͨ���ı������   ���ǰ�����ͨ�ķ�ʽ ����  
		 + *   
		 + *   
		 + *  ʵ���ļ��ϴ��Ĳ��裺
		 + *  01.����DiskFileItemFactory���� ���û������Ĵ�С  ��ŵ�λ��  �����Բ����� ��Ĭ��ֵ
		 + *  02.ͨ��DiskFileItemFactory���� ������ ServletFileUpload  ���Ϳ���֪�����ǵ������Ƿ����ļ��ϴ�����
		 + *  03.ͨ��ServletFileUpload�����  parseRequest���� ��ȡList<FileItem>
		 + *  04.��list���Ͻ��б�����ÿ����һ�ζ�Ҫʹ��FileItem���е�isFormField�������ж��Ƿ�Ϊ�ļ�
		 + *      001.��ͨ�ֶ�  ʹ�� getFieldName()  ��getString() ����ȡ�ֶ������ֶ�ֵ
		 + *      002.�ļ�   ʹ��getInputStream  getName  getOutputStream*/
	/*	request.setCharacterEncoding("UTF-8");
		Datail datail=new Datail();
		datail.setAuthor(request.getParameter("author"));
		datail.setTitle(request.getParameter("title"));
		datail.setContent(request.getParameter("content"));
		datail.setCreateDate(new Date());
		datail.setPicPath(request.getParameter("picPath"));
		datail.setSummary(request.getParameter("summary"));
		 DateFormat df = new SimpleDateFormat("yyyy-MM-dd");  
		try {
			datail.setCreateDate(df.parse(request.getParameter("createDate")));
		} catch (ParseException e) {
			System.err.println("���ڸ�ʽ����ȷ");
		}
		
		
		DatailSeriver datailSeriver=new DatailSeriverImpl();
		boolean flag = datailSeriver.addDatail(datail);
		if (flag) {
			
			request.getRequestDispatcher("ListServlet").forward(request, response);
		}*/
		
		System.out.println("��ʱ�ļ���λ��"+System.getProperty("java.io.temdir"));
		//��Ϊ��������  ��Ҫһ�����Ŷ���
		Datail datail=new Datail();
		//01.����DiskFileItemFactory����
		DiskFileItemFactory factory=new DiskFileItemFactory();
		//02.ͨ��DiskFileItemFactory���� ����ServletFileUpload
		ServletFileUpload upload=new ServletFileUpload(factory);
		//�ж��ǲ��� �ļ��ϴ�����
		boolean flag = upload.isMultipartContent(request);
		if (flag) {
			//03.ͨ��ServletFileUpload�����parseReequest������ȡLisi<FileItem>
			try {
				List<FileItem> items = upload.parseRequest(request);
				//�Լ��Ͻ��б��� ÿһ�ζ�Ҫʹ��FileItem���е�isFormFiled()���ж��ǲ����ļ�
				Iterator<FileItem> its = items.iterator();
				while (its.hasNext()) {
					//��ȡÿһ��
					FileItem item = its.next();
					if (item.isFormField()) {//��ͨ�ֶ�
						//001.��ͨ�ֶ� ʹ��getFiledName()��getString()����ȡ�ֶ������ֶ�ֵ
						String fieldName = item.getFieldName();
						if (fieldName.equals("title")) {
							datail.setTitle(item.getString("UTF-8"));
						}else if (fieldName.equals("author")) {
							datail.setAuthor(item.getString("UTF-8"));
						}else if (fieldName.equals("summary")) {
							datail.setSummary(item.getString("UTF-8"));
						}else if (fieldName.equals("createDate")) {
							datail.setCreateDate(new SimpleDateFormat("MM/dd/yyyy").parse(item.getString("UTF-8")));
						}else if (fieldName.equals("content")) {
							datail.setContent(item.getString("UTF-8"));
						}else if (fieldName.equals("categoryId")) {
							datail.setCategoryId(Integer.parseInt(item.getString("UTF-8")));
						}
					}else {//�ļ��ϴ�
						//ָ���ļ��ϴ���λ��getServletContext ��ȡ������Ŀ�ڷ�������λ��==��
						String uploadPath = request.getSession().getServletContext().getRealPath("upload/");
						File file=new File(uploadPath) ;
						if (!file.exists()) {//���������Ǵ���
							file.mkdirs();
						}
						String fileName  = item.getName();//�ļ�����
						if (!fileName .equals("")&&fileName!=null) {//�ж��û��Ƿ�ѡ�����ļ��ϴ�
							File uploadFile=new File(fileName);//�ϴ����ļ�
							File saveFile=new File(uploadPath, uploadFile.getName());
							//���������
							item.write(saveFile);
							datail.setPicPath(uploadFile.getName());
						}
					}
					
				}
				DatailSeriver datailSeriver=new DatailSeriverImpl();
				boolean flag1 = datailSeriver.addDatail(datail);
				
				if (flag1) {
					request.getRequestDispatcher("ListServlet").forward(request, response);
				}else {
					response.sendRedirect("/FindCategoryServlet");
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		
		}
		
		
	}
	
	
}
