<%--
	Here you could do any styling job you want , all CSS stuff.
--%>
<%@ taglib uri="http://www.zkoss.org/dsp/web/core" prefix="c" %>

div.z-modeltable {
	background: #DAE7F6;
	border: 1px solid #86A4BE;
	overflow: hidden;
	zoom: 1;
}
div.z-modeltable-header, div.z-modeltable-header tr, div.z-modeltable-footer {
	border: 0; width: 100%;
}
div.z-modeltable-header, div.z-modeltable-footer {
	overflow: hidden;
}
div.z-modeltable-header tr.z-columns, div.z-modeltable-header tr.z-auxhead {
	background-color: #C3E7FB;
	background-repeat: repeat-x;
	background-image: url(${c:encodeURL('~./zul/img/grid/column-bg.png')});
}
div.z-modeltable-header th.z-column, div.z-modeltable-header th.z-auxheader {
	overflow: hidden;
	border: 1px solid;
	border-color: #DAE7F6 #9EB6CE #9EB6CE #DAE7F6;
	white-space: nowrap;
	padding: 2px;
	font-size: ${fontSizeM}; font-weight: normal;
	position: relative;
}
div.z-modeltable-header .z-column-sort div.z-column-cnt {
	cursor: pointer;
	padding-right: 9px;
	background: transparent no-repeat 99% center;
	background-image: url(${c:encodeURL('~./zul/img/sort/v_hint.gif')});
}
div.z-modeltable-header .z-column-sort-asc div.z-column-cnt {
	cursor: pointer;
	padding-right: 9px;
	background-color:transparent;
	background-position: 99% center;
	background-repeat: no-repeat;
	background-image:url(${c:encodeURL('~./zul/img/sort/v_asc.gif')});
}
div.z-modeltable-header .z-column-sort-asc, div.z-modeltable-header .z-column-sort-dsc {
	background: #DDEEFB repeat-x 0 0;
	background-image:url(${c:encodeURL('~./zul/img/grid/column-over.png')});
}
div.z-modeltable-header .z-column-sort-dsc div.z-column-cnt {
	cursor: pointer;
	padding-right: 9px;
	background:transparent ;
	background-position: 99% center;
	background-repeat: no-repeat;
	background-image:url(${c:encodeURL('~./zul/img/sort/v_dsc.gif')});
}

div.z-modeltable-body {
	background: white; border: 0; overflow: auto; width: 100%;
}

/*--*/
tr.z-modeltable-row td.z-modeltable-row-inner, tr.z-modeltable-row .z-modeltable--cell {
	background: white; border-top: none; border-left: 1px solid white;
	border-right: 1px solid #CCC; border-bottom: 1px solid #DDD;
}
tr.z-modeltable-odd td.z-modeltable--inner,
tr.z-modeltable-odd .z-modeltable-cell,
tr.z-modeltable-odd {
	background: #F0FAFF;
}