1. 코틀린 문법에 어색하여 코틀린에서 제공하는 함수를 잘 사용하지 않았습니다.  
 oAuth2 kakao login 기능구현에 목적을 두었으며 코틀린학습 뒤 다시 작성할 예정입니다.

2. 'todo' 패키지는 본 oAuth Login 로직과 무관합니다.  
 코틀린으로 jpa를 이용해 db연결 테스트용입니다.
 
3. main/MainController.kt에서 리프레시토큰, 카카오유저 이름정보를 
  DB에 저장합니다.
  
4. 카카오 업체의 설정값은 resources/application.yml에 작성하였습니다.  
 client-id, secret-id는 개인정보이므로 삭제하였습니다.

5. oAuth2Client 라이브러리를 활용하였습니다.
