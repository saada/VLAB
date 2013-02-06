VLAB
====

# Design:

1) One Entry Point that check a state machine (stored on the server session).  
2) Populate one pageContainer div  
3) Every pageServlet or widgetServlet should extend a class that checks the state for each request including role validation.  
4) Validate every request on both client side and server side.

