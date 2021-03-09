<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="Author" content="Aebin">
<title>카카오페이 결제</title>
<!-- 카카오페이 -->
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>

<script type="text/javascript">
 $(function(){
        var IMP = window.IMP; // 생략가능
        IMP.init('imp71459192'); // 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용
        var msg;
        
        IMP.request_pay({
            pg : 'kakaopay',
            pay_method : '',
            merchant_uid : 'merchant_' + new Date().getTime(),
            name : '${ price }'+'포인트',
            amount : '${ price }',
            buyer_email : '',
            buyer_name : '${ loginUser.nickname }',
            buyer_tel : '',
            buyer_addr : '',
            buyer_postcode : '123-456',
            m_redirect_url : 'http://www.iamport.kr/mobile/landing' // 결제 완료 후 보낼 컨트롤러의 메소드명 
        }, function(rsp) {
            if ( rsp.success ) {
                //[1] 서버단에서 결제정보 조회를 위해 jQuery ajax로 imp_uid 전달하기
                jQuery.ajax({
                    url: "/payments/complete", //cross-domain error가 발생하지 않도록 주의해주세요
                    type: 'POST',
                    dataType: 'json',
                    data: {
                        imp_uid : rsp.imp_uid,
                        amount: rsp.paid_amount
                        //기타 필요한 데이터가 있으면 추가 전달
                    }
                }).done(function(data) {
                    //[2] 서버에서 REST API로 결제정보확인 및 서비스루틴이 정상적인 경우
                    if ( everythings_fine ) {
                        msg = '결제가 완료되었습니다.';
                        msg += '\n고유ID : ' + rsp.imp_uid;
                        msg += '\n상점 거래ID : ' + rsp.merchant_uid;
                        msg += '\결제 금액 : ' + rsp.paid_amount;
                        msg += '카드 승인번호 : ' + rsp.apply_num;
                        
                        alert(msg);
                        location.href="<%=request.getContextPath()%>/pSuccess.do?price=${price}&member=${sessionScope.loginUser.nickname}";
                    } else {
                        //[3] 아직 제대로 결제가 되지 않았습니다.
                        //[4] 결제된 금액이 요청한 금액과 달라 결제를 자동취소처리하였습니다.
                    }
                });
                //성공시 이동할 페이지
               location.href="<%=request.getContextPath()%>/pSuccess.do?price=${price}&member=${sessionScope.loginUser.nickname}";
            } else {
                msg = '결제에 실패하였습니다.';
                msg += '에러내용 : ' + rsp.error_msg;
                //실패시 이동할 페이지
                location.href="'kakao.do'"; 
                alert(msg);
            }
        });
        
    });
    </script> 
</head>
<body>

</body>
</html>



