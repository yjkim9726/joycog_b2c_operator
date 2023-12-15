// document.addEventListener("DOMContentLoaded", function() {
//     document.getElementById('loginButton').addEventListener('click', function() {
//         var loginId = document.getElementById('loginId').value;
//         var password = document.getElementById('password').value;
//
//         // 간단한 입력 검증
//         if (loginId === '' || password === '') {
//             alert('Username and password are required!');
//             return;
//         }
//
//         // 로그인 데이터 객체 생성
//         var loginData = {
//             loginId: loginId,
//             password: password
//         };
//
//         // 서버에 로그인 요청을 보내는 코드 (axios 사용)
//         sendLoginRequest(loginData);
//     });
// });
//
// function sendLoginRequest(loginData) {
//     axios.post('/doLogin', loginData)
//         .then(response => {
//             alert(response.data)
//             console.log('Login successful:', response.data);
//         })
//         .catch(error => {
//             console.error('Login failed:', error);
//         });
// }
