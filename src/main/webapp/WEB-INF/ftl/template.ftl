<!DOCTYPE ${doctype}>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>肏日${fuckked}</title>
</head>
<body>
    <center>
        ${msg} <br /><hr />
        陈冠希肏交
        <#list list as fuckked>
            ${fuckked}<#sep>,
        </#list>。
        <hr />

        <#list 25..100 as num>
            ${num}
            <#if num%50 == 0>
                <#break>
            </#if>
        </#list>
        <hr />

        <#switch switcher>
            <#case "Fuck">
                肏
                <#break>
            <#case "Shit">
                粪
                <#break>
            <#case "Bitch">
                婊
                <#break>
            <#case "Prostitute">
                鸡
                <#break>
        </#switch>
        <hr />

        <#function avg avg1 avg2 avg3>
            <#return (avg1+avg2+avg3)/3>
        </#function>
        肏他妈的平均结果：${avg(12345.6789,233.4321,88888.76543210)}
        <hr />

        <#if age &gt; 60>
            <font color="#a52a2a">老年人</font>
        <#elseif age &gt; 45>
            <font color="#daa520">中年人</font>
        <#elseif age &gt; 30>
            <font color="green">成年人</font>
        <#else>
            <font color="aqua">青年人</font>
        </#if>
        <hr />

        dav -> ${"dav"?cap_first}
        <hr />

        sonofabitchassholefucker fuckyou fuck you fuck_you! -> ${"sonofabitchassholefucker fuckyou fuck you fuck_you!"?capitalize}
        <hr />

        fuckyou -> <#if "fuck_$^#*!#you"?contains("k_$^#*!#y")> contains "k_$^#*!#y" </#if>
        <hr />

    </center>
</body>
</html>