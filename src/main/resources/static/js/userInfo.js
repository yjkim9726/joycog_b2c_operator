document.addEventListener("DOMContentLoaded", function() {

    document.getElementById('search-text').style.visibility = 'hidden'
    document.getElementById('myTab').style.visibility = 'hidden'

    document.getElementById('search_btn').addEventListener('click', function() {
        const uid = document.getElementById('uid').value;
        if (uid === "" || uid == null || isNaN(uid)){
            alert("UID를 확인해주세요.")
        } else {
            sendUserInfo(uid)
        }
    });

    document.getElementById('btn-userInfo').addEventListener('click', function() {
        const uid = document.getElementById('uid').value;
        document.getElementById('btn-userInfo').classList.add('active');
        document.getElementById('btn-goldInfo').classList.remove('active');
        sendUserInfo(uid)
    });

    document.getElementById('btn-goldInfo').addEventListener('click', function() {
        const uid = document.getElementById('uid').value;
        document.getElementById('btn-userInfo').classList.remove('active');
        document.getElementById('btn-goldInfo').classList.add('active');
        sendGoldInfo(uid)
    });
});

function sendUserInfo(uid) {
    axios.get('/user/info', {params: { uid: uid } })
    .then((response) => {
        console.log('성공', response.data);
        const userInfo = response.data
        if (userInfo !== 'noUser') {
            document.getElementById('td_uid').innerHTML = userInfo.uid;
            document.getElementById('td_createAccountDate').innerHTML = userInfo.createAccountDate;
            document.getElementById('td_lastAccessDate').innerHTML = userInfo.lastAccessDate;
            document.getElementById('td_os').innerHTML = userInfo.os;
            document.getElementById('td_version').innerHTML = userInfo.version;
            document.getElementById('td_gold').innerHTML = userInfo.gold;
            document.getElementById('td_C10').innerHTML = '캐릭터: ' + userInfo.countC10 + ' / ' + userInfo.maxCountC10;
            document.getElementById('td_C20').innerHTML = '탐사선: ' + userInfo.countC20 + ' / ' + userInfo.maxCountC20;
            document.getElementById('td_C30').innerHTML = '부스터: ' + userInfo.countC30 + ' / ' + userInfo.maxCountC30;
            document.getElementById('td_C40').innerHTML = '펫: ' + userInfo.countC40 + ' / ' + userInfo.maxCountC40;
            document.getElementById('td_C50').innerHTML = '오라: ' + userInfo.countC50 + ' / ' + userInfo.maxCountC50;
            document.getElementById('td_G10').innerHTML = '캐롯러너: ' + userInfo.stageG10 +' / 60';
            document.getElementById('td_G11').innerHTML = '컬러슈터: ' + userInfo.stageG11 +' / 60';
            document.getElementById('td_G12').innerHTML = '점핑래빗: ' + userInfo.stageG12 +' / 60';
            document.getElementById('userInfo').classList.add('show','active');
            document.getElementById('goldInfo').classList.remove('show','active');
            document.getElementById('myTab').style.visibility = 'visible'
            document.getElementById('myTabContent').style.visibility = 'visible'
        } else {
            document.getElementById('myTab').style.visibility = 'hidden'
            document.getElementById('myTabContent').style.visibility = 'hidden'
            document.getElementById('search-text').style.visibility = 'visible'
        }
    })
    .catch(error => {
        alert(error);
    });
}

function sendGoldInfo(uid) {
    axios.get('/user/gold-info', {params: { uid: uid } })
    .then((response) => {
        console.log('성공', response.data);
        const goldInfo = response.data;
        let table = "";
        if (goldInfo !== 'noUser') {
            for (const info of goldInfo) {
                table += '<tr>';
                table += '<th scope=\"row\">' + info.date +'</th>';
                table += '<td>'+ info.logDescription +'</td>';
                table += '<td>'+ info.value +'</td>';
                table += '<td>'+ info.gold +'</td>';
                table += '</tr>';
                console.log(table);
            }
            console.log(table)
            document.querySelector('#tableGoldInfo tbody').innerHTML = table
            document.getElementById('goldInfo').classList.add('show','active');
            document.getElementById('userInfo').classList.remove('show','active');
            document.getElementById('myTab').style.visibility = 'visible'
            document.getElementById('myTabContent').style.visibility = 'visible'
        } else {
        document.getElementById('tableGoldInfo').style.display = 'none'
        document.getElementById('search-text').style.visibility = 'visible'
    }
    })
    .catch(error => {
        alert(error);
    });

}
