import { registerPlugin } from '@capacitor/core';

import type { RestartPlugin } from './definitions';

const Restart = registerPlugin<RestartPlugin>('Restart', {
  web: () => import('./web').then(m => new m.RestartWeb()),
});

export * from './definitions';
export { Restart };
