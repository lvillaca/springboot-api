## RESULT=`curl -v -k --data "grant_type=client_credentials&client_id=<client_id>&client_secret=<client_secret>" https://idp.com.br/auth/realms/API/protocol/openid-connect/token`



RESULT=`curl  -k --data "grant_type=client_credentials&client_id=oidcapi&client_secret=017c2137-153a-4cab-bfc3-dcfca356bb82" https://oidc.transpetro.com.br/auth/realms/API/protocol/openid-connect/token`


echo $RESULT | python -m json.tool
TOKEN=`echo $RESULT | sed 's/.*access_token":"\([^"]*\).*/\1/'`

echo $TOKEN

echo attempting to pull from token..............................................................................

 curl  -k  -H "Authorization: Bearer $TOKEN"      https://localhost:8974/api/funcionario/LHNV
## curl  -k -X GET -H "Authorization: Bearer $TOKEN"   -H "Accept: application/json"   https://localhost:8974/funcionario/LHNV
