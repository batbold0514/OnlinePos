jQuery.fn.zeninput = function(options){
var options = jQuery.extend({
	error: false, // Ð­Ð»ÐµÐ¼ÐµÐ½Ñ‚ Ð¾Ñ‚Ð¾Ð±Ñ€Ð°Ð¶Ð°ÐµÐ¼Ñ‹Ð¹ Ð¿Ñ€Ð¸ Ð¾ÑˆÐ¸Ð±ÐºÐµ
	comment: false, // Ð­Ð»ÐµÐ¼ÐµÐ½Ñ‚ Ð¾Ñ‚Ð¾Ð±Ñ€Ð°Ð¶Ð°ÐµÐ¼Ñ‹ Ð¿Ñ€Ð¸ Ñ€ÐµÐ´Ð°ÐºÑ‚Ð¸Ñ€Ð¾Ð²Ð°Ð½Ð¸Ð¸
	calculatewrapper: false, // Ð­Ð»ÐµÐ¼ÐµÐ½Ñ‚ Ð±ÑƒÐ´ÐµÑ‚ Ð¾Ñ‚Ð¾Ð±Ñ€Ð°Ð¶ÐµÐ½ Ð¿Ñ€Ð¸ Ñ€Ð°ÑÑ‡ÐµÑ‚Ð°Ñ…
	calculate: false, // Ð­Ð»ÐµÐ¼ÐµÐ½Ñ‚ ÐºÑƒÐ´Ð° Ð±ÑƒÐ´ÐµÑ‚ Ð²Ñ‹Ð²Ð¾Ð´Ð¸Ñ‚ÑÑ Ñ€ÐµÐ·ÑƒÐ»ÑŒÑ‚Ð°Ñ‚ Ð²Ñ‹Ñ‡Ð¸ÑÐ»ÐµÐ½Ð¸Ñ
	oncalculate: false, // Ð¤ÑƒÐ½ÐºÑ†Ð¸Ñ Ð²Ñ‹Ð·Ñ‹Ð²Ð°ÐµÑ‚ÑÑ ÐµÑÐ»Ð¸ Ð²Ð²ÐµÐ´ÐµÐ½Ñ‹ [+,-,*,/,(,)]
	onendcalculate: false, // Ð¤ÑƒÐ½ÐºÑ†Ð¸Ñ Ð²Ñ‹Ð·Ñ‹Ð²Ð°ÐµÑ‚ÑÑ ÐµÑÐ»Ð¸ ÑƒÐ´Ð°Ð»ÐµÐ½Ñ‹ Ð²ÑÐµ [+,-,*,/,(,)]
	onready: false, // Ð¤ÑƒÐ½ÐºÑ†Ð¸Ñ Ð²Ñ‹Ð·Ñ‹Ð²Ð°ÐµÑ‚ÑÑ Ð¿Ñ€Ð¸ Ð¿Ð¾Ð´Ð³Ð¾Ñ‚Ð¾Ð²ÐºÐµ ÑÐ»ÐµÐ¼ÐµÐ½Ñ‚Ð°
	onfocus: false, // Ð¤ÑƒÐ½ÐºÑ†Ð¸Ñ Ð²Ñ‹Ð·Ñ‹Ð²Ð°ÐµÑ‚ÑÑ Ð¿Ñ€Ð¸ ÑƒÑÑ‚Ð°Ð½Ð¾Ð²ÐºÐµ Ñ„Ð¾ÐºÑƒÑÐ°
	onblur: false, // Ð¤ÑƒÐ½ÐºÑ†Ð¸Ñ Ð²Ñ‹Ð·Ñ‹Ð²Ð°ÐµÑ‚ÑÑ Ð¿Ñ€Ð¸ Ð¿Ð¾Ñ‚ÐµÑ€Ðµ Ñ„Ð¾ÐºÑƒÑÐ° (Ð² Ñ„ÑƒÐ½ÐºÑ†Ð¸ÑŽ Ð¿ÐµÑ€ÐµÐ´Ð°ÐµÑ‚ÑÑ ÐºÐ¾Ð½ÐµÑ‡Ð½Ñ‹Ð¹ Ñ€ÐµÐ·ÑƒÐ»ÑŒÑ‚Ð°Ñ‚Ñ‹ Ð²Ð²Ð¾Ð´Ð°)
	onerror: false, // Ð¤ÑƒÐ½ÐºÑ†Ð¸Ñ Ð²Ñ‹Ð·Ñ‹Ð²Ð°ÐµÑ‚ÑÑ Ð¿Ñ€Ð¸ Ð¿Ð¾Ð¿Ñ‹Ñ‚ÐºÐµ Ð²Ð²Ð¾Ð´Ð° Ð·Ð°Ð¿Ñ€ÐµÑ‰ÐµÐ½Ð½Ñ‹Ñ… ÑÐ¸Ð¼Ð²Ð¾Ð»Ð¾Ð²
	onenter: false, // Ð¤ÑƒÐ½ÐºÑ†Ð¸Ñ Ð²Ñ‹Ð·Ñ‹Ð²Ð°ÐµÑ‚ÑÑ ÐµÑÐ»Ð¸ Ð½Ð°Ð¶Ð°Ñ‚Ð° ÐºÐ»Ð°Ð²Ð¸ÑˆÐ° enter (Ð²Ñ‹Ð·Ñ‹Ð²Ð°ÐµÑ‚ÑÑ Ð”Ðž onblur)
	onescape: false, // Ð¤ÑƒÐ½ÐºÑ†Ð¸Ñ Ð²Ñ‹Ð·Ñ‹Ð²Ð°ÐµÑ‚ÑÑ ÐµÑÐ»Ð¸ Ð½Ð°Ð¶Ð°Ñ‚Ð° ÐºÐ»Ð°Ð²Ð¸ÑˆÐ° escape (Ð²Ñ‹Ð·Ñ‹Ð²Ð°ÐµÑ‚ÑÑ Ð”Ðž onblur)
	oninput: false, // Ð¤ÑƒÐ½ÐºÑ†Ð¸Ñ Ð²Ñ‹Ð·Ñ‹Ð²Ð°ÐµÑ‚ÑÑ Ð¿Ñ€Ð¸ Ð²Ð²Ð¾Ð´Ðµ Ð»ÑŽÐ±Ð¾Ð³Ð¾ ÑÐ¸Ð¼Ð²Ð¾Ð»Ð° (Ð² Ñ„ÑƒÐ½ÐºÑ†Ð¸ÑŽ Ð¿ÐµÑ€ÐµÐ´Ð°ÐµÑ‚ÑÑ Ð²Ð²ÐµÐ´ÐµÐ½Ð½Ñ‹Ð¹ ÑÐ¸Ð¼Ð²Ð¾Ð»)
	ifnul: '', // Ð¡Ð¸Ð¼Ð²Ð¾Ð» Ð²ÑÑ‚Ð°Ð²Ð»ÑÐµÐ¼Ñ‹Ð¹ ÐµÑÐ»Ð¸ Ð²Ð²ÐµÐ´ÐµÐ½Ñ‹Ðµ Ð´Ð°Ð½Ð½Ñ‹Ðµ Ð¾ÑˆÐ¸Ð±Ð¾Ñ‡Ð½Ñ‹ Ð¸Ð»Ð¸ 0
	sign: false // ÐŸÐ¾ÐºÐ°Ð·Ñ‹Ð²Ð°Ñ‚ÑŒ Ð·Ð½Ð°Ðº Ð¼Ð¸Ð½ÑƒÑ Ð¿Ñ€Ð¸ Ð²Ð²Ð¾Ð´Ðµ Ð¾Ñ‚Ñ€Ð¸Ñ†Ð°Ñ‚ÐµÐ»ÑŒÐ½Ð¾Ð³Ð¾ Ð·Ð½Ð°Ñ‡ÐµÐ½Ð¸Ñ
},options);
var costToString = function(cost, fixed){
	var triadSeparator = ' ';
	var decSeparator = ',';
	var minus = '&minus;';
	var num = '0';
	var numd = '';
	var fractNum = 2;
	fixed = ( !fixed ) ? fixed = 2 : fixed;
	var fixedTest = '00';
	if( fixed != 2 ){
		fixedTest = '';
		for( var i = 0; i < fixed; i++ ){
			fixedTest += String('0');
		}
	}
	if( !isNaN( parseFloat(cost) ) ){
		num = parseFloat(Math.abs(cost)).toFixed(fixed).toString();
		numd = num.substr(num.indexOf('.')+1, fixed).toString();
		num = parseInt(num).toString();
		var regEx = /(\d+)(\d{3})/;
		while (regEx.test(num)){
			num = num.replace(regEx,"$1"+triadSeparator+"$2");
		}
		if( numd != fixedTest ){
			var lastZeros = /[0]*$/g
			num += decSeparator+numd.replace(lastZeros,'');
		}
		if( cost < 0 ) num = 'âˆ’'+num;
	}
	return num;
}
return this.each(function(){
	var nchars = new RegExp(/[\!\@\#\â„–\$\%\^\&\=\[\]\\\'\;\{\}\|\"\:\<\>\?~\`\_A-ZÐ-Ð¯a-zÐ°-Ñ]/);
	var achars = "1234567890+-/*,. ";
	var errTimer = undefined;
	var inObj = this;
	var elemW = 68;
	var oldVal = 0;
	var newVal = 0;
	var t = { left:0, top:0 };
	var absW = jQuery(inObj).outerWidth(true);
	var absH = jQuery(inObj).outerHeight(true);
	var absT = t.top - 4;
	var absL = isNaN( t.left + parseInt(jQuery(inObj).css('marginLeft'),10) - 4 )?0:(t.left + parseInt(jQuery(inObj).css('marginLeft'),10) - 4);
	var regClean = new RegExp(' ','gi');
	var aripm = new RegExp(/[\+\-\*\/]/);
	var aripmSt = new RegExp(/^[\+\-\*\/]/);
	var toOldVal = false;
	/* Ð¡Ð¾Ð·Ð´Ð°ÐµÐ¼ Ð½Ðµ ÑƒÐºÐ°Ð·Ð°Ð½Ð½Ñ‹Ðµ ÑÐ»ÐµÐ¼ÐµÐ½Ñ‚Ñ‹ */
	if(!options.calculatewrapper){
		options.calculatewrapper = jQuery('<div class="calculatewrapper"></div>');
		jQuery(options.calculatewrapper).append('<div class="actWr">=</div>');
		jQuery(options.calculatewrapper).css({
			'position':'absolute',
			'left':absL+'px',
			'top':absT+'px',
			'visibility':'hidden',
			'zIndex':'0',
			'background':'#cedeea',
			'width':absW+'px',
			'padding':absH+6+'px 3px 3px 3px'
		});
		jQuery(inObj).after(options.calculatewrapper);
	}
	if(!options.calculate){
		options.calculate = jQuery('<span class="calcaction" style="font-weight:bold;"></span>');
		jQuery('.actWr' ,options.calculatewrapper).css({'padding':'3px 0px 3px 0px'}).append(options.calculate);
	}
	/* Ð¡Ð¾Ð·Ð´Ð°ÐµÐ¼ Ð½Ðµ ÑƒÐºÐ°Ð·Ð°Ð½Ð½Ñ‹Ðµ ÑÐ»ÐµÐ¼ÐµÐ½Ñ‚Ñ‹ */
	jQuery(this).focus(function(){
		/* Ð˜Ð½Ð¸Ñ†Ð¸Ð°Ð»Ð¸Ð·Ð°Ñ†Ð¸Ñ */
		oldVal = parseFloat( String(inObj.value).replace(/ /g, '').replace(/,/g,'.'), 10 );
		( isNaN(oldVal) ) ? ( oldVal = 0 ) : oldVal;
		newVal = oldVal;
		//jQuery(inObj).css({'position':'relative', 'zIndex':2});
		t = jQuery(inObj).position();
		absT = t.top - 4;
		var mL = jQuery(inObj).css('marginLeft');
		mL = isNaN( parseInt(mL,10) )?( 0 ):( parseInt(mL,10) );
		absL = t.left + mL - 6;
		absW = jQuery(inObj).outerWidth(true);
		absH = jQuery(inObj).outerHeight(true);
		jQuery(options.calculatewrapper).css({'left':absL+'px', 'top':absT-3+'px', 'width': absW+'px', 'padding':absH+6+'px 6px 2px 6px'});
		if (options.comment) $(options.comment).css({'display': 'block'});
		/* Ð˜Ð½Ð¸Ñ†Ð¸Ð°Ð»Ð¸Ð·Ð°Ñ†Ð¸Ñ */
		if(options.onfocus) options.onfocus(this);
	});
	jQuery(this).blur(function(){
		if ( toOldVal ){
			newVal = oldVal;
		}
		toOldVal = false;
		if( options.comment ) jQuery(options.comment).css({'display':'none'});
		if( options.error ) jQuery(options.error).css({'display':'none'});
		jQuery(options.calculatewrapper).css({'visibility': 'hidden'});
		jQuery(inObj).css({'position':'static'});
		if( options.sign ){
			var sign = ( newVal < 0 )?( '-' ):( '' );
		}else{
			var sign = '';
		}
		newVal = Math.abs(newVal);
		if( newVal != 0 ){
			$(inObj).val( sign+costToString( newVal ) );
			if(options.onblur) options.onblur(inObj, sign+costToString( newVal ));
		}else{
			$(inObj).val( options.ifnul );
			if(options.onblur) options.onblur(inObj, options.ifnul);
		}
	});
	jQuery(this).keypress(function(e){
		var k, i;
		var tAllow = false;
		if (!e.charCode){
			k = String.fromCharCode(e.which);
			c = e.which;
		}else{
			k = String.fromCharCode(e.charCode);
			c = e.charCode;
		}
		if ( c == 37 || c == 39 ){ return true; }
		if( !e.ctrlKey ){
			var res=nchars.test(k);
			if ( res ){
				if(options.comment) jQuery(options.comment).css({'display':'none'});
				if(options.error) jQuery(options.error).css({'display':'block'});
				if(options.onerror) options.onerror(inObj);
				jQuery(inObj).addClass('error');
				clearTimeout(errTimer);
				errTimer = setTimeout(function(){
					if( options.error ) jQuery(options.error).css({'display':'none'});
					if( options.comment ) jQuery(options.comment).css({'display':'block'});
					$(inObj).removeClass('error');
				}, 3000);
				return false;
			}else{
				if ( e.keyCode == 13 ){
					if(options.onenter) setTimeout(function(){ options.onenter(inObj, newVal); }, 100);
					inObj.blur();
				}
			}
		}
	});
	jQuery(this).keyup(function(e){
		newVal = String(inObj.value).replace(/ /g, '').replace(/,/g, '.');
		if ( e.keyCode == 27 ){
			toOldVal = true;
			if(options.onescape) options.onescape(inObj, oldVal);
			inObj.blur();
			return;
		}
		
		var res = aripm.test(newVal);
		if(res){
			res = aripmSt.test(newVal);
			jQuery(inObj).css({'position':'relative', 'zIndex':2});
			jQuery(options.calculatewrapper).css({'visibility': 'visible'});
			if (res){
				var tStr = String( oldVal ) + String(newVal);
				try{
					newVal = parseFloat( eval( tStr ), 10 );
					newVal = isNaN( newVal )?( 0 ):( newVal );
					newVal = isFinite( newVal )?( newVal ):( 0 );
					jQuery(options.calculate).html( costToString( newVal ) );
				} catch(e) {
					newVal = 0;
					jQuery(options.calculate).html( newVal );
				}
			}else{
				var tStr = String(newVal);
				try{
					newVal = parseFloat( eval( tStr ), 10 );
					newVal = isNaN( newVal )?( 0 ):( newVal );
					newVal = isFinite( newVal )?( newVal ):( 0 );
					jQuery(options.calculate).html( costToString( newVal ) );
				} catch(e) {
					newVal = 0;
					jQuery(options.calculate).html( newVal );
				}
			}
			if( options.oncalculate ) options.oncalculate(newVal);
		}else{
			jQuery(options.calculatewrapper).css({'visibility': 'hidden'});
			jQuery(inObj).css({'position':'static'});
			if ( isNaN( parseFloat(newVal, 10) ) ){
				newVal = 0;
				jQuery(options.calculate).html( newVal );
			}else{
				jQuery(options.calculate).html( costToString( parseFloat(newVal, 10) ) );
			}
			if( options.onendcalculate ) options.onendcalculate(newVal);
		}
		if(options.oninput) options.oninput(this, e.keyCode);
	});
	
	if(options.onready) options.onready(this);
});
};