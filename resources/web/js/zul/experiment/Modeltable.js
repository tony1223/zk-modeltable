zul.experiment.Modeltable = zk.$extends(zk.Widget, {
	$define: {
		items: function() {
			this.rerender();
		},
		headers: function() {
			this.rerender();
		}
	},
	drawJSONTag: function(out, json, ref) {
		var cnt =json['cnt'] , 
			tag = json['tag'], 
			childtag = json['ctag'],
			attrs =  json['attr'];
		
		out.push("<", tag);
		for (var k in attrs) 
			out.push(" ",k, '="', attrs[k], '"');
			
		out.push(">");
		if (cnt) {
			for (var i = 0, len = cnt.length; i < len; ++i) {
				if (cnt[i] instanceof Object) {
					this.drawJSONTag(out, cnt[i]);
				} else if(childtag)
						this.drawJSONTag(out, {tag:childtag,cnt:[ cnt[i] ]}, ref); 
				else if (cnt[i] == 'z$wgt') {
					if (ref.child) {
						ref.child.redraw(out);
						ref.child = ref.child.nextSibling;
					}
				} else {
					if(childtag)
						this.drawJSONTag(out, {tag:childtag,cnt:[ cnt[i] ]});
					else
						out.push(cnt[i]);
				}
			}
		}
		out.push("</", tag, ">");
	},
	unbind_: function() {
		this.$supers(zul.experiment.Modeltable, 'unbind_', arguments);
	},
	
	getZclass: function() {
		return this._zclass != null ? this._zclass : "z-modeltable";
	}
});
