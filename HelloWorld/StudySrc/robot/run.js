const Nightmare = require('nightmare');
const nightmare = Nightmare({show: true});

const run = async() => {
	await login();
	// await nightmare.goto('http://www.baidu.com');
	// await nightmare.type('#kw', 'Hello world!');
	// await nightmare.click('#su');
}

const login = async() => {
	await nightmare.goto('http://jde.kerryprops.com.cn:83/jde/E1Menu.maf');
	await nightmare.wait('#loginLegalDisclaimer');
	// await nightmare.click('#T01 :nth-child(1)')
	// await nightmare.wait('#signin_form');

	await nightmare.click('#Password')
	await nightmare.type('#User', 'SHAJBW1');
	await nightmare.type('#Password', 'wujianbing');
	await nightmare.click('#buttonstylenormal margin-top5');
}

run();