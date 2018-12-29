<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="Content-Style-Type" content="text/css"/>
    <title></title>
    <style type="text/css">
        body {
            font-family: pingfang sc light;
        }
        .center{
            text-align: center;
            width: 100%;
        }

        th,td{
            border: 1px  #ccc;
            text-align: center;
            word-wrap : break-word ;
            word-break:break-all;
        }
        table{
            border-collapse: collapse;
            table-layout: fixed;

        }


    </style>
</head>
<body>
<!--第一页开始-->
<div class="page" >
    <div class="center"><p>${templateName}</p></div>
    <div><p>iText官网:${ITEXTUrl}</p></div>
    <div><p>FreeMarker官网:${freeMarkerUrl}</p></div>
    <div><p>JFreeChart教程:${JFreeChartUrl}</p></div>

    <p>静态logo图</p>
    <div>
        <img src="${imageUrl}" alt="美团点评" width="110" height="20.8"/>
    </div>
</div>
<!--第一页结束-->
<!---分页标记-->
<span style="page-break-after:always;"></span>
<!--第二页开始-->
<div class="page">
    <div>第二页开始了</div>
    <div>列表值:</div>
    <#--<div>
    <#list scores as item>
        <div style="float: left;width: 617px;position: relative;right: -40px;">
            <table class="moduleTable">
                <tbody>
                <tr>
                    <td style="text-align: center;width: 40px;valign:top;height:50px;"><span style="font-size:10px;">${(module.subject)!}</span></td>
                    <td style="text-align: center;width: 80px;height:50px;"><span style="font-size:10px;">${(module.amount)!}</span></td>
                    <td style="text-align: center;width: 80px;height:50px;"><span style="font-size:10px;">${(module.confirm)!}</span></td>
                    <td style="text-align: center;width: 20px;height:50px;"><span style="font-size:10px;">${(module.attachno)!}</span></td>
                    <td style="text-align: center;width: 121px;height:50px;"><span style="font-size:10px;">${(module.accountTitle)!}<br/>${(module.account)!}</span></td>
                    <td style="text-align: center;width: 110px;height:50px;"><span style="font-size:10px;">${(module.accountBank)!}<br/>${(module.openBank)!}</span></td>
                    <td style="text-align: center;width: 20px;height:50px;"><span style="font-size:10px;">${(module.type)!}</span></td>
                    <td style="text-align: center;width: 160px;height:50px;"><span style="font-size:10px;">${(module.reason)!}</span></td>
                </tr>
                </tbody>
            </table>
        </div>
    </#list>
    </div>-->
    <div class="firstLine"></div>
<div class="page">
    <div style="float: left;text-align: left;width: 40px;"></div>
    <div style="float: left;width: 617px;position: relative;">
        <table>
            <thead>
            <tr>
                <th  style="width: 91px;height:15px;"><span style="font-size:10px;">商户名称</span></th>
                <th style="width: 92px;height:15px;"><span style="font-size:10px;">商户具体地址</span></th>
                <th style="width: 92px;height:15px;"><span style="font-size:10px;">法人代表姓名</span></th>
                <th style="width: 91px;height:15px;"><span style="font-size:10px;">商户注册号</span></th>
                <th style="width: 90px;height:15px;"><span style="font-size:10px;">主要联系人电话</span></th>
                <th style="width: 90px;height:15px;"><span style="font-size:10px;">主要联系人邮箱</span></th>
            </tr>
            </thead>
        </table>
    </div>
		<#list scores as record>
			<div style="float: left;width: 617px;position: relative;right: -40px;"">
				<table>
                    <tbody>
                    <tr>
                        <td style="width: 91px;height:15px;"><span style="font-size:10px;height:30px;">${(record.retailName)!}</span></td>
                        <td style="width: 92px;height:15px;"><span style="font-size:10px;height:30px;">${(record.retailAddr)!}</span></td>
                        <td style="width: 92px;height:15px;"><span style="font-size:10px;height:30px;">${(record.legalName)!}</span></td>
                        <td style="width: 91px;height:15px;"><span style="font-size:10px;height:30px;">${(record.retailRegcode)!}</span></td>
                        <td style="width: 90px;height:15px;"><span style="font-size:10px;height:30px;">${(record.primUserPhone)!}</span></td>
                        <td style="width: 90px;height:15px;"><span style="font-size:10px;height:30px;">${(record.primUserEmail)!}</span></td>
                    </tr>
                    </tbody>
                </table>
			</div>
    </#list>
    </div>

</div>


<!--第二页结束-->
</body>
</html>