zul.experiment.Modeltable = zk.$extends(zk.Widget, {
	$define: {
		items: function(){ 
			this.rerender();		
		},
		headers:function(){
			this.rerender();
		}
	},
	
	$init:function(){
		this.$supers(zul.experiment.Modeltable,'$init', arguments);
	},

	bind_: function () {
		this.$supers(zul.experiment.Modeltable,'bind_', arguments);

	},

	unbind_: function () {
		this.$supers(zul.experiment.Modeltable,'unbind_', arguments);
	},

	getZclass: function () {
		return this._zclass != null ? this._zclass: "z-modeltable";
	}
});
