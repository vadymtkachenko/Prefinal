<%@ include file="/includes/directive/localeAndJSTL.jspf" %>

<div class="w3-top">
 <ul class="w3-navbar w3-theme-d2 w3-large">

   <li class="w3-hide-small lan-dropdown" style="float:right;">
	        <div class="lan-dropdown-content">
				   <div class="lan-itemlist" onclick="ruForm.submit();"> 
				      <form id="ruForm" action="/change">
				      	  <img src="<c:url value="/static/images/language/ru.png" />" alt="" width="30" height="20" onclick="ruForm.submit();">
						  <input type="hidden" name="command" value="ChangeLanguage">
						  <input type="hidden" name="userUrl" value="${pageContext.request.servletPath}">
						  <input type="hidden" name="lan" value="ru">
						  
		  			 </form>
			      </div>
			      
			      <div class="lan-itemlist" onclick="enForm.submit();">
			      	<form id="enForm" action="/change">
				      	  <img src="<c:url value="/static/images/language/en.png" />" alt="" width="30" height="20" onclick="enForm.submit();">
						  <input type="hidden" name="command" value="ChangeLanguage">
						  <input type="hidden" name="userUrl" value="${pageContext.request.servletPath}">
						  <input type="hidden" name="lan" value="en">
						  
		  			 </form>
			      </div>
				      
    		</div>
    </li>
  </ul>
  </div>