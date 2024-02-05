/*!
* Start Bootstrap - Modern Business v5.0.7 (https://startbootstrap.com/template-overviews/modern-business)
* Copyright 2013-2023 Start Bootstrap
* Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-modern-business/blob/master/LICENSE)
*/
// This file is intentionally blank
// Use this file to add JavaScript to your project
var currencyInput = document.querySelector('input[type="currency"]')
var currency = 'GBP' // https://www.currency-iso.org/dam/downloads/lists/list_one.xml

// format inital value
onBlur({target:currencyInput})

// bind event listeners
currencyInput.addEventListener('focus', onFocus)
currencyInput.addEventListener('blur', onBlur)

function localStringToNumber( s ){
    return Number(String(s).replace(/[^0-9.,-]+/g,""))
}

function onFocus(e){
    var value = e.target.value;
    e.target.value = value ? localStringToNumber(value) : ''
}

function onBlur(e){
    var value = e.target.value

    var options = {
        maximumFractionDigits : 2,
        currency              : currency,
        style                 : "currency",
        currencyDisplay       : "symbol"
    }

    e.target.value = (value || value === 0)
        ? localStringToNumber(value).toLocaleString(undefined, options)
        : ''
}