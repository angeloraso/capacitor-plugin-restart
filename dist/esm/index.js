import { registerPlugin } from '@capacitor/core';
const Restart = registerPlugin('Restart', {
    web: () => import('./web').then(m => new m.RestartWeb()),
});
export * from './definitions';
export { Restart };
//# sourceMappingURL=index.js.map