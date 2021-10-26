'use strict';

Object.defineProperty(exports, '__esModule', { value: true });

var core = require('@capacitor/core');

const Restart = core.registerPlugin('Restart', {
    web: () => Promise.resolve().then(function () { return web; }).then(m => new m.RestartWeb()),
});

class RestartWeb extends core.WebPlugin {
    async enable() {
        throw this.unimplemented('Not implemented on web.');
    }
    async disable() {
        throw this.unimplemented('Not implemented on web.');
    }
}

var web = /*#__PURE__*/Object.freeze({
    __proto__: null,
    RestartWeb: RestartWeb
});

exports.Restart = Restart;
//# sourceMappingURL=plugin.cjs.js.map
