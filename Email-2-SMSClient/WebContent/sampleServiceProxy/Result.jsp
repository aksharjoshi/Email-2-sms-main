<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleServiceProxyid" scope="session" class="connection.ServiceProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleServiceProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleServiceProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        sampleServiceProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        connection.Service getService10mtemp = sampleServiceProxyid.getService();
if(getService10mtemp == null){
%>
<%=getService10mtemp %>
<%
}else{
        if(getService10mtemp!= null){
        String tempreturnp11 = getService10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        String firstname_1id=  request.getParameter("firstname16");
            java.lang.String firstname_1idTemp = null;
        if(!firstname_1id.equals("")){
         firstname_1idTemp  = firstname_1id;
        }
        String lastname_2id=  request.getParameter("lastname18");
            java.lang.String lastname_2idTemp = null;
        if(!lastname_2id.equals("")){
         lastname_2idTemp  = lastname_2id;
        }
        String emailid_3id=  request.getParameter("emailid20");
            java.lang.String emailid_3idTemp = null;
        if(!emailid_3id.equals("")){
         emailid_3idTemp  = emailid_3id;
        }
        String password_4id=  request.getParameter("password22");
            java.lang.String password_4idTemp = null;
        if(!password_4id.equals("")){
         password_4idTemp  = password_4id;
        }
        java.lang.String signUp13mtemp = sampleServiceProxyid.signUp(firstname_1idTemp,lastname_2idTemp,emailid_3idTemp,password_4idTemp);
if(signUp13mtemp == null){
%>
<%=signUp13mtemp %>
<%
}else{
        String tempResultreturnp14 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(signUp13mtemp));
        %>
        <%= tempResultreturnp14 %>
        <%
}
break;
case 24:
        gotMethod = true;
        String username_5id=  request.getParameter("username35");
            java.lang.String username_5idTemp = null;
        if(!username_5id.equals("")){
         username_5idTemp  = username_5id;
        }
        String password_6id=  request.getParameter("password37");
            java.lang.String password_6idTemp = null;
        if(!password_6id.equals("")){
         password_6idTemp  = password_6id;
        }
        connection.Client signIn24mtemp = sampleServiceProxyid.signIn(username_5idTemp,password_6idTemp);
if(signIn24mtemp == null){
%>
<%=signIn24mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">userid:</TD>
<TD>
<%
if(signIn24mtemp != null){
%>
<%=signIn24mtemp.getUserid()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">emailid:</TD>
<TD>
<%
if(signIn24mtemp != null){
java.lang.String typeemailid29 = signIn24mtemp.getEmailid();
        String tempResultemailid29 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeemailid29));
        %>
        <%= tempResultemailid29 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">lastname:</TD>
<TD>
<%
if(signIn24mtemp != null){
java.lang.String typelastname31 = signIn24mtemp.getLastname();
        String tempResultlastname31 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typelastname31));
        %>
        <%= tempResultlastname31 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">firstname:</TD>
<TD>
<%
if(signIn24mtemp != null){
java.lang.String typefirstname33 = signIn24mtemp.getFirstname();
        String tempResultfirstname33 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typefirstname33));
        %>
        <%= tempResultfirstname33 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>