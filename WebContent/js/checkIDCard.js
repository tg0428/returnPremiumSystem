
function checkEnergyCard(){
 var allowancePersonValue=$("#psw").val();
 //�Ƿ�Ϊ��
 if(allowancePersonValue==""){
  $("#allowancePersonIDTips").addClass("aTip");
  $("#allowancePersonIDTips").html("���֤����Ϊ��");
  return false;
 }
 //У�鳤�ȣ�����
 else if(isCardNo(allowancePersonValue) === false)
 {
     $("#allowancePersonIDTips").addClass("aTip");
  $("#allowancePersonIDTips").html("����������֤���벻��ȷ������������");
  return false;
 }
 //���ʡ��
 else if(checkProvince(allowancePersonValue) === false)
 {
     $("#allowancePersonIDTips").addClass("aTip");
  $("#allowancePersonIDTips").html("����������֤���벻��ȷ,����������");
  return false;
 }
 //У������
 else if(checkBirthday(allowancePersonValue) === false)
 {
     $("#allowancePersonIDTips").addClass("aTip");
  $("#allowancePersonIDTips").html("����������֤�������ղ���ȷ,����������");
  return false;
 }
 //����λ�ļ��
 else if(checkParity(allowancePersonValue) === false)
 {
     $("#allowancePersonIDTips").addClass("aTip");
  $("#allowancePersonIDTips").html("�������֤У��λ����ȷ,����������");
  return false;
 }else{
  $("#allowancePersonIDTips").removeClass("aTip");
  $("#allowancePersonIDTips").html("");
  return true;
 }

}

//���֤ʡ�ı���
var vcity={ 11:"����",12:"���",13:"�ӱ�",14:"ɽ��",15:"���ɹ�",
        21:"����",22:"����",23:"������",31:"�Ϻ�",32:"����",
        33:"�㽭",34:"����",35:"����",36:"����",37:"ɽ��",41:"����",
        42:"����",43:"����",44:"�㶫",45:"����",46:"����",50:"����",
        51:"�Ĵ�",52:"����",53:"����",54:"����",61:"����",62:"����",
        63:"�ຣ",64:"����",65:"�½�",71:"̨��",81:"���",82:"����",91:"����"
       };

//�������Ƿ���Ϲ淶���������ȣ�����
function isCardNo(card){
 //���֤����Ϊ15λ����18λ��15λʱȫΪ���֣�18λǰ17λΪ���֣����һλ��У��λ������Ϊ���ֻ��ַ�X
 var reg = /(^\d{15}$)|(^\d{17}(\d|X)$)/;
 if(reg.test(card) === false){
  //alert("demo");
  return false;
 }
 return true;
}

//ȡ���֤ǰ��λ,У��ʡ��
function checkProvince(card){
 var province = card.substr(0,2);
 if(vcity[province] == undefined){
  return false;
 }
 return true;
}

//��������Ƿ���ȷ
function checkBirthday(card){
 var len = card.length;
 //���֤15λʱ������Ϊʡ��3λ���У�3λ���꣨2λ���£�2λ���գ�2λ��У��λ��3λ������Ϊ����
 if(len == '15'){ 
     var re_fifteen = /^(\d{6})(\d{2})(\d{2})(\d{2})(\d{3})$/;
     var arr_data = card.match(re_fifteen);
     var year = arr_data[2];
     var month = arr_data[3];
     var day = arr_data[4];
     var birthday = new Date('19'+year+'/'+month+'/'+day);
     return verifyBirthday('19'+year,month,day,birthday);
 }
 //���֤18λʱ������Ϊʡ��3λ���У�3λ���꣨4λ���£�2λ���գ�2λ��У��λ��4λ����У��λĩβ����ΪX
 if(len == '18'){
     var re_eighteen = /^(\d{6})(\d{4})(\d{2})(\d{2})(\d{3})([0-9]|X)$/;
     var arr_data = card.match(re_eighteen);
     var year = arr_data[2];
     var month = arr_data[3];
     var day = arr_data[4];
     var birthday = new Date(year+'/'+month+'/'+day);
     return verifyBirthday(year,month,day,birthday);
 }
 return false;
}

//У������
function verifyBirthday(year,month,day,birthday){
 var now = new Date();
 var now_year = now.getFullYear();
 //�������Ƿ����
 if(birthday.getFullYear() == year && (birthday.getMonth() + 1) == month && birthday.getDate() == day)
 {
     //�ж���ݵķ�Χ��3�굽100��֮��)
     var time = now_year - year;
     if(time >= 3 && time <= 100)
     {
         return true;
     }
     return false;
 }
 return false;
}

//У��λ�ļ��
function checkParity(card){
 //15λת18λ
 card = changeFivteenToEighteen(card);
 var len = card.length;
 if(len == '18'){
     var arrInt = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2);
     var arrCh = new Array('1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2');
     var cardTemp = 0, i, valnum;
     for(i = 0; i < 17; i ++)
     {
         cardTemp += card.substr(i, 1) * arrInt[i];
     }
     valnum = arrCh[cardTemp % 11];
     if (valnum == card.substr(17, 1))
     {
         return true;
     }
     return false;
 }
 return false;
}

//15λת18λ���֤��
function changeFivteenToEighteen(card){
 if(card.length == '15')
 {
     var arrInt = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2);
     var arrCh = new Array('1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2');
     var cardTemp = 0, i;  
     card = card.substr(0, 6) + '19' + card.substr(6, card.length - 6);
     for(i = 0; i < 17; i ++)
     {
         cardTemp += card.substr(i, 1) * arrInt[i];
     }
     card += arrCh[cardTemp % 11];
     return card;
 }
 return card;
}