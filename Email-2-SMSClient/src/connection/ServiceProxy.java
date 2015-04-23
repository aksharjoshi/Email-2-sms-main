package connection;

public class ServiceProxy implements connection.Service {
  private String _endpoint = null;
  private connection.Service service = null;
  
  public ServiceProxy() {
    _initServiceProxy();
  }
  
  public ServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initServiceProxy();
  }
  
  private void _initServiceProxy() {
    try {
      service = (new connection.ServiceServiceLocator()).getService();
      if (service != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)service)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)service)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (service != null)
      ((javax.xml.rpc.Stub)service)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public connection.Service getService() {
    if (service == null)
      _initServiceProxy();
    return service;
  }
  
  public java.lang.String signUp(java.lang.String firstname, java.lang.String lastname, java.lang.String emailid, java.lang.String password) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.signUp(firstname, lastname, emailid, password);
  }
  
  public connection.Client signIn(java.lang.String username, java.lang.String password) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.signIn(username, password);
  }
  
  
}